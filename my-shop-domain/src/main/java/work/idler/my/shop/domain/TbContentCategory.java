package work.idler.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.persistence.BaseTreeEntity;

import javax.validation.constraints.NotNull;

/**
 * 分类管理
 * @Auther:http://blog.idler.work
 * @Date:2019/4/9
 * @Description:work.idler.my.shop.domain
 * @version:1.0
 */
@Data
public class TbContentCategory extends BaseTreeEntity {

    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;

    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
