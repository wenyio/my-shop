package work.idler.my.shop.web.api.service;

import work.idler.my.shop.domain.TbUser;

/**
 * 会员管理
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.api.service
 * @version:1.0
 */
public interface TbUserService {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
