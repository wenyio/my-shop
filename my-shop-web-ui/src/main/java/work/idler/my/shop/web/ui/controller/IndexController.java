package work.idler.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import work.idler.my.shop.commons.utils.HttpClientUtils;
import work.idler.my.shop.commons.utils.MapperUtils;
import work.idler.my.shop.web.ui.api.API;
import work.idler.my.shop.web.ui.api.ContentsApi;
import work.idler.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * 首页
 * @Auther:http://blog.idler.work
 * @Date:2019/4/17
 * @Description:work.idler.my.shop.web.ui.controller
 * @version:1.0
 */
@Controller
public class IndexController {

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        // 请求幻灯片
        requestContentsPPT(model);
        return "index";
    }

    /**
     * 请求幻灯片
     * @param model
     */
    private void requestContentsPPT(Model model) {
        List<TbContent> tbContents = ContentsApi.ppt();
        model.addAttribute("ppt", tbContents);
    }

}
