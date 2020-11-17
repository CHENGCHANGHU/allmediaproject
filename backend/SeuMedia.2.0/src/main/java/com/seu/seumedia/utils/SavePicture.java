package com.seu.seumedia.utils;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;

public class SavePicture {
    public static boolean SavePictureToDir(String savePath,MultipartFile file) {
        //String savePath = "E:\\图片\\allMediaPictures\\";
        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(savePath);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }
            is.close();
            os.close();
            // System.out.println("写入文件成功！");
            return true;

        } catch (Exception e) {
            return false;
        }


    }
}