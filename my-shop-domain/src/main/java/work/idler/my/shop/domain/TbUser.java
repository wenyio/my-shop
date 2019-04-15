package work.idler.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import work.idler.my.shop.commons.persistence.BaseEntity;
import work.idler.my.shop.commons.utils.RegexpUtils;

import javax.validation.constraints.Pattern;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/4
 * @Description:work.idler.my.shop.domain
 * @version:1.0
 */
@Data
public class TbUser extends BaseEntity {

    @Length(min = 6, max = 20, message = "姓名的长度必须介于6 - 20位之间")
    private String username;

    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码长度必须介于6 - 20位之间")
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
}
