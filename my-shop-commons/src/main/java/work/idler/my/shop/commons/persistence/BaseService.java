package work.idler.my.shop.commons.persistence;

import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层得基类
 * @Auther:http://blog.idler.work
 * @Date:2019/4/13
 * @Description:work.idler.my.shop.commons.persistence
 * @version:1.0
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询全部
     * @return
     */
    public List<T> selectAll();

    /**
     * 保存 更新
     * @param entity
     */
    BaseResult save(T entity);

    void delete(Long id);

    /**
     * 通过id查询user
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
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);
}
