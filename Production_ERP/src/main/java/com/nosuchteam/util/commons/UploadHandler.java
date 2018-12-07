package com.nosuchteam.util.commons;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: Evan
 * @Date: 2018/12/7 13:38
 * @Description:
 */
public class UploadHandler {

    public static Object delete(File deleteFile){
        if (deleteFile.exists()) {
            deleteFile.delete();
            return new Data("success");
        }
        return new Data("");
    }

    public static Object save(String uploadType, String uploadPath, MultipartFile uploadFile) throws IOException {
        File destDir = new File(uploadPath, "resources/" + uploadType);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        String uploadName = new Date().toString().hashCode() + "-" + uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File(destDir, uploadName));
        return new Data(0, "resources/" + uploadType + "/" + uploadName);
    }
}
