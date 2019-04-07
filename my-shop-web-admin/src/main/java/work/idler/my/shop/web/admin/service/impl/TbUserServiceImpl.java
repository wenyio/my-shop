package work.idler.my.shop.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.utils.RegexpUtils;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.web.admin.dao.TbUserDao;
import work.idler.my.shop.web.admin.service.TbUserService;

import java.util.Date;
import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.web.admin.service.impl
 * @version:1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbuser(tbUser);

        // 通过验证
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());

            // 新增用户
            if(tbUser.getId() == null) {
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }

            // 编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
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

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {
        return tbUserDao.search(tbUser);
    }

    /**
     * 用户信息得有效性验证
     * @param tbUser
     */
    private BaseResult checkTbuser (TbUser tbUser) {
        // 默认为成功
        BaseResult baseResult = BaseResult.success();

        // 非空验证
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        }

        else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确,请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空,请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空,请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空,请重新输入");
        }

        else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机格式不正确,请重新输入");
        }

        return baseResult;
    }
}
