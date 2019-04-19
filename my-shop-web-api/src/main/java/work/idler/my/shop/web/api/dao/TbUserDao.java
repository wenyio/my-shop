package work.idler.my.shop.web.api.dao;

import org.springframework.stereotype.Repository;
import work.idler.my.shop.domain.TbUser;

/**
 * 会员管理
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.api.dao
 * @version:1.0
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
