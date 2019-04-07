package work.idler.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/3
 * @Description:work.idler.my.shop.web.admin.web.controller
 * @version:1.0
 */
@Controller
public class MainController {

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
