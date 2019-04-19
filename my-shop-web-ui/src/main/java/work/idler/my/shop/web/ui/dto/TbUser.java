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
public class TbUser implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
