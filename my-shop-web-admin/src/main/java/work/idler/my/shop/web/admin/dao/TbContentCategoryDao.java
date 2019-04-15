package work.idler.my.shop.web.admin.dao;

import org.springframework.stereotype.Repository;
import work.idler.my.shop.commons.persistence.BaseDao;
import work.idler.my.shop.commons.persistence.BaseTreeDao;
import work.idler.my.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/9
 * @Description:work.idler.my.shop.web.admin.dao
 * @version:1.0
 */
@Repository
public interface TbContentCategoryDao extends BaseTreeDao<TbContentCategory> {

}
