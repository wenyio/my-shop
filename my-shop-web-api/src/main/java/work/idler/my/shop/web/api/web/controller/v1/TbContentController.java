package work.idler.my.shop.web.api.web.controller.v1;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.idler.my.shop.commons.dto.BaseResult;
import work.idler.my.shop.domain.TbContent;
import work.idler.my.shop.domain.TbContentCategory;
import work.idler.my.shop.web.api.service.TbContentService;
import work.idler.my.shop.web.api.web.dto.TbContentDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:http://blog.idler.work
 * @Date:2019/4/17
 * @Description:work.idler.my.shop.web.api.web.controller
 * @version:1.0
 */
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;

        if (id == null) {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 根据类别 ID 查询列表内容
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "{category_id}", method = RequestMethod.GET)
    public BaseResult findContentByCategoryId(@PathVariable(value = "category_id") Long categoryId) {
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(categoryId);

        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent, dto); // 把 tbContent 对象值 反射 给 dto
                tbContentDTOS.add(dto);
            }
        }

        return BaseResult.success("成功", tbContentDTOS);
    }
}
