package work.idler.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import work.idler.my.shop.commons.dto.PageInfo;
import work.idler.my.shop.commons.persistence.BaseDao;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.persistence.BaseService;
import work.idler.my.shop.domain.TbContent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/14
 * @Description:work.idler.my.shop.web.admin.abstracts
 * @version:1.0
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 根据 id 删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 更新
     * @param entity
     */
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 查询总笔数
     * @return
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;
    }
}
