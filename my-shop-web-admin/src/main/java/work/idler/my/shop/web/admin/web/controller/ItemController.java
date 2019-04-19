package work.idler.my.shop.web.admin.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.dto.PageInfo;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.web.admin.abstracts.AbstractBaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/15
 * @Description:work.idler.my.shop.web.admin.web.controller
 * @version:1.0
 */
public class ItemController extends AbstractBaseController {
    @Override
    public String list() {
        return null;
    }

    @Override
    public String form() {
        return null;
    }

    @Override
    public String save(BaseEntity entity, RedirectAttributes redirectAttributes, Model model) {
        return null;
    }

    @Override
    public BaseResult delete(String ids) {
        return null;
    }

    @Override
    public PageInfo page(HttpServletRequest request, BaseEntity entity) {
        return null;
    }

    @Override
    public String detail(BaseEntity entity) {
        return null;
    }
}
