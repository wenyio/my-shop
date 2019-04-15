package work.idler.my.shop.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.dto.PageInfo;
import work.idler.my.shop.commons.utils.RegexpUtils;
import work.idler.my.shop.commons.validator.BeanValidator;
import work.idler.my.shop.domain.TbContent;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import work.idler.my.shop.web.admin.dao.TbContentDao;
import work.idler.my.shop.web.admin.service.TbContentService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/10
 * @Description:work.idler.my.shop.web.admin.service.impl
 * @version:1.0
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        System.out.println(tbContent.getTitle());
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }

        // 验证通过
        else {
            tbContent.setUpdated(new Date());

            // 新增内容
            if(tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }

            // 编辑内容
            else {
                update(tbContent);
            }

            return BaseResult.success("保存内容信息成功");
        }
    }



}
