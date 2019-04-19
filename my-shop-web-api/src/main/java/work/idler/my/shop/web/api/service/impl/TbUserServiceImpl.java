package work.idler.my.shop.web.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.web.api.dao.TbUserDao;
import work.idler.my.shop.web.api.service.TbUserService;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.api.service.impl
 * @version:1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {

        TbUser user = tbUserDao.login(tbUser);

        if (user != null) {
            // 将明文密码加密
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
