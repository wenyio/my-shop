package work.idler.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/15
 * @Description:work.idler.my.shop.commons.persistence
 * @version:1.0
 */
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
