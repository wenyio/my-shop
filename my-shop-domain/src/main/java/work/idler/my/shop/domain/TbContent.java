package work.idler.my.shop.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import work.idler.my.shop.commons.persistence.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * 内容管理
 * @Auther:http://blog.idler.work
 * @Date:2019/4/10
 * @Description:work.idler.my.shop.domain
 * @version:1.0
 */
@Data
public class TbContent extends BaseEntity {

    @Length(min = 1, max = 20, message = "标题长度介于1 - 20之间")
    private String title;

    @Length(min = 1, max = 20, message = "子标题长度介于1 - 20之间")
    private String subTitle;

    @Length(min = 1, max = 50, message = "标题描述长度介于1 - 50之间")
    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1,max = 1000, message = "内容不可为空")
    private String content;

    @NotNull(message = "父级类目不能为空")
    private TbContentCategory tbContentCategory;
}
