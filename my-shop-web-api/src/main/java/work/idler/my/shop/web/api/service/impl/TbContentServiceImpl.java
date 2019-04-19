package work.idler.my.shop.web.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.idler.my.shop.domain.TbContent;
import work.idler.my.shop.domain.TbContentCategory;
import work.idler.my.shop.web.api.dao.TbContentDao;
import work.idler.my.shop.web.api.service.TbContentService;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/17
 * @Description:work.idler.my.shop.web.api.service.impl
 * @version:1.0
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;


    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);
        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.selectByCategoryId(tbContent);
    }
}
