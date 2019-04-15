package work.idler.my.shop.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.dto.PageInfo;
import work.idler.my.shop.commons.validator.BeanValidator;
import work.idler.my.shop.domain.TbContent;
import work.idler.my.shop.domain.TbContentCategory;
import work.idler.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import work.idler.my.shop.web.admin.dao.TbContentCategoryDao;
import work.idler.my.shop.web.admin.service.TbContentCategoryService;

import java.util.Date;
import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/9
 * @Description:work.idler.my.shop.web.admin.service.impl
 * @version:1.0
 */
@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService{

    @Override
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null) {
            return BaseResult.fail(validator);
        }

        else {
            TbContentCategory parent = entity.getParent();
            // 如果没有选择父级节点则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                // 0 代表根目录
                parent.setId(0L);
            }

            entity.setUpdated(new Date());
            // 新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);

                // 判断当前新增得节点有没有父级节点
                if (parent.getId() != 0L) {
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null) {
                        // 为父级节点设置 isParent 为 true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }

                // 父级节点为 0, 表示为根目录
                else {
                    // 根目录一定是父级
                    entity.setIsParent(true);
                }

                dao.insert(entity);
            }

            else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

}
