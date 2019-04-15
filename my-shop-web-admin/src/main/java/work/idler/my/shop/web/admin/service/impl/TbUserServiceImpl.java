package work.idler.my.shop.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.dto.PageInfo;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.utils.RegexpUtils;
import work.idler.my.shop.commons.validator.BeanValidator;
import work.idler.my.shop.domain.TbContentCategory;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import work.idler.my.shop.web.admin.dao.TbUserDao;
import work.idler.my.shop.web.admin.service.TbUserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.web.admin.service.impl
 * @version:1.0
 */
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser, TbUserDao> implements TbUserService {

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }

        // 通过验证
        else {
            tbUser.setUpdated(new Date());

            // 新增用户
            if(tbUser.getId() == null) {
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }

            // 编辑用户
            else {
                update(tbUser);
            }

            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);
        if(tbUser != null) {
            // 明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            // 判断加密后的密码和数据存放的密码是否匹配, 匹配则表示登录成功
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

}
