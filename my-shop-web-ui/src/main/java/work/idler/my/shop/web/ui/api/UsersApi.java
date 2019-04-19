package work.idler.my.shop.web.ui.api;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.http.message.BasicNameValuePair;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.commons.utils.HttpClientUtils;
import work.idler.my.shop.commons.utils.MapperUtils;
import work.idler.my.shop.web.ui.dto.TbUser;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.ui.api
 * @version:1.0
 */
public class UsersApi {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = (TbUser) MapperUtils.json2ListByTree(json, "data", TbUser.class);
        return user;
    }
}
