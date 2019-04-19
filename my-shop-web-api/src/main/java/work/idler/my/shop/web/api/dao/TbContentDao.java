package work.idler.my.shop.web.api.dao;

import org.springframework.stereotype.Repository;
import work.idler.my.shop.domain.TbContent;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/17
 * @Description:work.idler.my.shop.web.api.dao
 * @version:1.0
 */
@Repository
public interface TbContentDao {

    /**
     * 根据类别 ID 查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
