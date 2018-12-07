package com.nosuchteam.controller;

import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.Page;
import com.nosuchteam.util.commons.UploadHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class CommonController {

    @RequestMapping("/{forward}")
    public String forward(@PathVariable String forward) {
        return forward;
    }

    @RequestMapping("/{getData}/get_data")
    public String getData(@PathVariable String getData) {
        return "forward:/" + getData + "/list?getData=List";
    }

    @RequestMapping("/{target}/get/{id}")
    public String get(@PathVariable String target,@PathVariable String id) {
        String byId = target == "manufacture" ? "manufactureSn" : target + "Id";
        return "forward:/" + target + "/search_" + target + "_by_" + byId + "?getData=Object&searchValue=" + id;
    }

    @ResponseBody
    @RequestMapping("/file/{operation}")
    public Object uploadFile(@PathVariable String operation, String fileName,
                             MultipartFile file, HttpServletRequest request) {
        try {
            String uploadPath = request.getServletContext().getRealPath("/WEB-INF");
            //判断是否删除操作
            return "delete".equals(operation) ?
                    UploadHandler.delete(new File(uploadPath, fileName)) : UploadHandler.save("pic",uploadPath,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data(-1, "");
    }

    @ResponseBody
    @RequestMapping("/pic/{operation}")
    public Object uploadImage(@PathVariable String operation, String picName,
                              MultipartFile uploadFile, HttpServletRequest request) {
        try {
            String uploadPath = request.getServletContext().getRealPath("/WEB-INF");
            return "delete".equals(operation) ?
                    UploadHandler.delete(new File(uploadPath, picName)) : UploadHandler.save("pic",uploadPath,uploadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data(-1, "");
    }

    @RequestMapping("/file/download")
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //获取文件路径
        String filePath = request.getServletContext().getRealPath("/WEB-INF") + "/" + fileName;
        //创建输入流
        InputStream is = new FileInputStream(filePath);
        //创建输出流
        ServletOutputStream os = response.getOutputStream();

        byte[] bytes = new byte[1024 * 10];
        int len;
        //设置报文头以及传输类型
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename="
                + URLEncoder.encode(fileName, "UTF-8"));
        //开始下载
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        is.close();
        os.close();
    }


}
