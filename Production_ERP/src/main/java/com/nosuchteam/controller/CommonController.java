package com.nosuchteam.controller;

import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.UploadHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

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

    @ResponseBody
    @RequestMapping({"/{judge}/add_judge", "/{judge}/edit_judge", "/{judge}/delete_judge"})
    public Object judge(@PathVariable String judge) {
        /*if (session.getAttribute("user") == null){
            return new Data(500, "请先登录", null);
        }*/
        return null;
    }

    @RequestMapping({"/{jump}/add", "/{jump}/edit"})
    public String jumpTo(@PathVariable String jump, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("add")) {
            return "plan_scheduling/" + jump + "_add";
        }
        return "plan_scheduling/" + jump + "_edit";
    }

    @RequestMapping("/{find}/find")
    public String find(@PathVariable String find, HttpSession session){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add(find + ":add");
        sysPermissionList.add(find + ":edit");
        sysPermissionList.add(find + ":delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "plan_scheduling/" + find + "_list";
    }

    @RequestMapping("/{module}/get/{id}")
    public String get(@PathVariable String module, @PathVariable String id) {
        String byId = "manufacture".equals(module) ? "manufactureSn" : module + "Id";
        return "forward:/" + module + "/search_" + module + "_by_" + byId + "?getData=Object&searchValue=" + id;
    }

    /**
     * 上传文件操作
     * @param operation 获取客户请求对文件的操作
     * @param fileName  操作的文件名
     * @param file      上传的文件
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/file/{operation}")
    public Object uploadFile(@PathVariable String operation, String fileName,
                             MultipartFile file, HttpServletRequest request) {
        try {
            String uploadPath = request.getServletContext().getRealPath("/WEB-INF");
            //判断是否删除操作
            return "delete".equals(operation) ?
                    UploadHandler.delete(new File(uploadPath, fileName)) :
                    UploadHandler.save("pic", uploadPath, file);
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
                    UploadHandler.delete(new File(uploadPath, picName)) :
                    UploadHandler.save("pic", uploadPath, uploadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data(-1, "");
    }

    @RequestMapping("/file/download")
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //获取文件路径
        String filePath = request.getServletContext().getRealPath("/WEB-INF") + "/" + fileName;
        //创建输入流
        InputStream is = null;
        //创建输出流
        ServletOutputStream os = null;
        try {

            is = new FileInputStream(filePath);
            os = response.getOutputStream();

            //设置报文头以及传输类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            byte[] bytes = new byte[1024*200];
            int len;
            //开始下载
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
           throw new Exception("文件下载失败");
        }finally {
            try {
                if(is != null){
                    is.close();
                }
                if(os != null){
                    os.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }





    }
}
