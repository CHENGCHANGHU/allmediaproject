package com.seu.seumedia.utils;

import com.alibaba.fastjson.JSON;
import com.seu.seumedia.entity.User;
import java.util.Date;

public class JSONUtil {

    public static String Entity2JSON(Object entity) {
        return JSON.toJSONString(entity);
    }

    public static void main(String[] args) {
        Date date=new Date();
        byte b=1;
        User user=new User(1,"张三","123","123456@163.com","18018031360",date,date,b,"0");
        System.out.println(Entity2JSON(user));

    }
}