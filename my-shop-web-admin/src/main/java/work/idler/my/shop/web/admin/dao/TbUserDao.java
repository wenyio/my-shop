package work.idler.my.shop.web.admin.dao;

import org.springframework.stereotype.Repository;
import work.idler.my.shop.domain.TbUser;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.web.admin.dao
 * @version:1.0
 */
@Repository
public interface TbUserDao {
    /**
     * 查询全部用户信息
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 新增
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 更新
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 根据id 查询用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 搜索
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
