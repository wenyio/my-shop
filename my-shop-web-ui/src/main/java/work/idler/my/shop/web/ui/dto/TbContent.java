package work.idler.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.ui.dto
 * @version:1.0
 */
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
