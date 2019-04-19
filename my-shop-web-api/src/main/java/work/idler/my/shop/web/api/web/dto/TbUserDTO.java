package work.idler.my.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员数据传输对象
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.api.web.dto
 * @version:1.0
 */
@Data
public class TbUserDTO implements Serializable {
    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
