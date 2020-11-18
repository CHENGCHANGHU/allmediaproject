package com.seu.seumedia.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCode {
    public static String getHashCode(String s){
        String result="";
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(s.getBytes());
            result = byteToHexString(messageDigest.digest());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static String byteToHexString(byte[] bytes){
        StringBuilder strB=new StringBuilder();
        for(int i=0;i<bytes.length;++i){
            String hex=Integer.toHexString(0xFF & bytes[i]);
            if(hex.length()==1){
                strB.append("0");
            }
            strB.append(hex);
        }
        return strB.toString();
    }
}

