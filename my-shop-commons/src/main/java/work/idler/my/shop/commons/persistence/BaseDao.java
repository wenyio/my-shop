package work.idler.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层得基类
 * @Auther:http://blog.idler.work
 * @Date:2019/4/13
 * @Description:work.idler.my.shop.commons.persistence
 * @version:1.0
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询全部
     * @return
     */
    public List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(T entity);

    /**
     * 更新
     * @param entity
     */
    void update(T entity);

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params 需要两个参数, start length
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);

    /**
     * 根据 id 删除
     * @param id
     */
    void delete(Long id);
}
