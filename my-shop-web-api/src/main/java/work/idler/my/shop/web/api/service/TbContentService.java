package work.idler.my.shop.web.api.service;

import work.idler.my.shop.domain.TbContent;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/17
 * @Description:work.idler.my.shop.web.api.service
 * @version:1.0
 */
public interface TbContentService {
    /**
     * 根据类别 ID 查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
