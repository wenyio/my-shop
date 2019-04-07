package work.idler.my.shop.web.admin.service;

import org.springframework.stereotype.Service;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.domain.TbUser;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.web.admin.service
 * @version:1.0
 */
public interface TbUserService {
    /**
     * 查询全部用户信息
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 插入
     * @param tbUser
     */
    BaseResult save(TbUser tbUser);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

    /**
     * 通过id查询user
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 搜索功能
     * @param keyword
     * @return
     */
    List<TbUser> search(String keyword);
}
