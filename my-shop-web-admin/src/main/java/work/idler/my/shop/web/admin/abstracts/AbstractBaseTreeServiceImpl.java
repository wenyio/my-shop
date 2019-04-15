package work.idler.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.persistence.BaseTreeDao;
import work.idler.my.shop.commons.persistence.BaseTreeService;

import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/14
 * @Description:work.idler.my.shop.web.admin.abstracts
 * @version:1.0
 */
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

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
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
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
     * 更新
     * @param entity
     */
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 根据父级节点 ID 查询所有子节点
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid) {
        return dao.selectByPid(pid);
    }
}
