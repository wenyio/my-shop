package work.idler.my.shop.web.ui.api;

import work.idler.my.shop.commons.utils.HttpClientUtils;
import work.idler.my.shop.commons.utils.MapperUtils;
import work.idler.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * 内容管理接口
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.ui.api
 * @version:1.0
 */
public class ContentsApi {
    public static List<TbContent> ppt() {
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        List<TbContent> tbContents = null;
        try {
            tbContents = MapperUtils.json2ListByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
