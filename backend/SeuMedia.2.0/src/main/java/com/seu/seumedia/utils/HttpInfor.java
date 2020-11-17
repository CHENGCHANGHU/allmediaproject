package com.seu.seumedia.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpInfor {
    //private HttpServletRequest request;

    public static  Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        if(request.getHeader("x-forwarded-for")!=null){
            map.put("ip",request.getHeader("x-forwarded-for"));
        }
        else{
            map.put("ip",request.getRemoteAddr());
        }
        String url=request.getRequestURL().toString();
        map.put("url",url);
        return map;
    }
}