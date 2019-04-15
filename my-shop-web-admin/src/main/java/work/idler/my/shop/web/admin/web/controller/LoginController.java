package work.idler.my.shop.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import work.idler.my.shop.commons.constant.ConstantUtils;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.web.admin.service.TbUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/3
 * @Description:work.idler.my.shop.web.admin.web.controller
 * @version:1.0
 */
@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录逻辑
     * @param email
     * @param password
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true)  String password, HttpServletRequest httpServletRequest, Model model){
        TbUser tbUser = tbUserService.login(email, password);

        // 登录失败
        if (tbUser == null) {
            model.addAttribute("message", "用户名或密码错误, 请重新输入! ");
            return login();
        }

        // 登录成功
        else {
            // 将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}























