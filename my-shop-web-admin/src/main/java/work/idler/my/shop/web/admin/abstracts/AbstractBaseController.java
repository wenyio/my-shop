package work.idler.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.dto.PageInfo;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.persistence.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/15
 * @Description:work.idler.my.shop.web.admin.abstracts
 * @version:1.0
 */
public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;

    /**
     * 跳转到列表页
     * @return
     */
    public abstract String list();
    /**
     * 跳转到表单页
     * @return
     */
    public abstract String form();

    /**
     * 保存信息
     * @param entity
     * @param redirectAttributes
     * @param model
     * @return
     */
    public abstract String save(T entity, RedirectAttributes redirectAttributes, Model model);

    /**
     * 删除
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);

    /**
     * 分页查询
     * @param request
     * @param entity
     * @return
     */
    public abstract PageInfo<T> page(HttpServletRequest request, T entity);

    /**
     * 跳转详情页
     * @param entity
     * @return
     */
    public abstract String detail(T entity);
}
