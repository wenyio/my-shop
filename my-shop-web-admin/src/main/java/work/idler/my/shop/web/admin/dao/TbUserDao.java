package work.idler.my.shop.web.admin.dao;

import org.springframework.stereotype.Repository;
import work.idler.my.shop.commons.persistence.BaseDao;
import work.idler.my.shop.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.web.admin.dao
 * @version:1.0
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
