package com.seu.seumedia.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class getCurrentDate {
    public static Date getCurrentDate()throws Exception{

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date=new Date();
        String strTime=bjSdf.format(date);
        Date newDate=bjSdf.parse(strTime);
        return newDate;

    }

    public static void main(String[] args)throws Exception {
        // System.out.println(getCurrentDate().toString());
        //System.out.println(getCurrentDate());
        Resource resource = new ClassPathResource("");
        String projectPath = resource.getFile().getAbsolutePath()+ "\\static\\img";
        System.out.println(projectPath);
        System.out.println(UUID.randomUUID());
    }

}
