package work.idler.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.persistence.BaseTreeEntity;
import work.idler.my.shop.commons.persistence.BaseTreeService;

import java.util.List;


/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/15
 * @Description:work.idler.my.shop.web.admin.abstracts
 * @version:1.0
 */
public abstract class AbstractBaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>>{

    @Autowired
    protected S service;

    /**
     * 跳转列表页
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页
     * @param entity
     * @return
     */
    public abstract String form(T entity);

    /**
     * 保存
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 树形结构
     * @param id
     * @return
     */
    public abstract List<T> treeDate(Long id);

    /**
     * 排序
     * @param sourceList 数据源集合
     * @param targetList 排序后集合
     * @param parentId 父节点id
     */
    protected void sortList(List<T> sourceList, List<T> targetList, Long parentId) {
        for (T sourceEntity : sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                // 判断有没有子节点, 如果有则继续追加
                if (sourceEntity.getIsParent()) {
                    for (T currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList, targetList, sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
