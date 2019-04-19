package work.idler.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 内容数据传输对象
 * @Auther:http://blog.idler.work
 * @Date:2019/4/17
 * @Description:work.idler.my.shop.web.api.web.dto
 * @version:1.0
 */
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
