package work.idler.my.shop.web.admin.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.web.admin.dao.TbUserDao;
import work.idler.my.shop.web.admin.service.TbUserService;

import java.util.Date;
import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.web.admin.service.test
 * @version:1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbUserDao tbUserDao;

    @Test
    public void test01() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("idler");
        tbUser.setEmail("1329208516@qq.com");
        tbUser.setPhone("18601549904");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("5211".getBytes()));
        tbUser.setUpdated(new Date());
        tbUser.setCreated(new Date());
        tbUserDao.update(tbUser);
    }
}
