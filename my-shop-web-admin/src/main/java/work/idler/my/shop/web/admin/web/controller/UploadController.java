package work.idler.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 文件上传控制器
 * @Auther:http://blog.idler.work
 * @Date:2019/4/11
 * @Description:work.idler.my.shop.web.admin.web.controller
 * @version:1.0
 */
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * 文件上传
     * @param dropFile DropZone
     * @param editorFiles wangEditor
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile[] editorFiles, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        // Dropzone 上传
        if (dropFile != null) {
            result.put("fileName", writeFile(dropFile, request));
        }

        // wangEditor 上传
        if (editorFiles != null && editorFiles.length > 0) {
            List<String> fileNames = new ArrayList<>();

            for (MultipartFile editorFile : editorFiles) {
                fileNames.add(writeFile(editorFile, request));
            }

            result.put("errno", 0);
            result.put("data", fileNames);
        }
        
        return result;
    }

    private String writeFile(MultipartFile multipartFile, HttpServletRequest request) {
        // 获取文件后缀
        String fileName = multipartFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        File file = new File(filePath);
        // 判断路径是否存在, 不存在则创建文件夹
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * scheme: 服务端提供得协议 http/ https
         * serverName: 服务器名称 localhost/ ip/ domain
         * serverPort: 服务器端口
         * http://localhost:8080
         */
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return serverPath + UPLOAD_PATH + file.getName();
    }

//    @ResponseBody
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile editorFile, HttpServletRequest request) {
//        Map<String, Object> result = new HashMap<>();
//
//        // 前端上传得文件
//        MultipartFile myFile = dropFile == null ? editorFile : dropFile;
//
//        // 获取文件后缀
//        String fileName = myFile.getOriginalFilename();
//        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
//        // 文件存放路径
//        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
//        File file = new File(filePath);
//        // 判断路径是否存在, 不存在则创建文件夹
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        // 将文件写入目标
//        file = new File(filePath, UUID.randomUUID() + fileSuffix);
//        try {
//            myFile.transferTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Dropzone 上传
//        if (dropFile != null) {
//            result.put("fileName", UPLOAD_PATH + file.getName());
//        }
//
//        // wangEditor 上传
//        else {
//            /**
//             * scheme: 服务端提供得协议 http/ https
//             * serverName: 服务器名称 localhost/ ip/ domain
//             * serverPort: 服务器端口
//             * http://localhost:8080
//             */
//            String severPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//            result.put("errno", 0);
//            result.put("data", new String[] {severPath + UPLOAD_PATH + file.getName()});
//        }
//
//        return result;
//    }
}
