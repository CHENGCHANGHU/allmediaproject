package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.Log;
import com.seu.seumedia.entity.User;
import com.seu.seumedia.mapper.LogMapper;
import com.seu.seumedia.mapper.UserInforMapper;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.service.RegistService;
import com.seu.seumedia.utils.HashCode;
import com.seu.seumedia.utils.getCurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegistServiceImpl implements RegistService {

    @Autowired(required=false)
    private UserMapper userMapper;
    @Autowired(required=false)
    private LogMapper logMapper;
    @Autowired(required = false)
    private UserInforMapper userInforMapper;

    public Map<String,String> regist(User user, Map<String,String> mapHttpHeader) throws Exception{
        Map<String,String> map= new HashMap<>();
        User userPhone=userMapper.selectByPhone(user.getPhone());
        User userEmail=userMapper.selectByEmail(user.getEmail());

        if(userPhone==null&&userEmail==null){
            user.setPassword(HashCode.getHashCode(user.getPassword()));
            userMapper.insert(user);
            map.put("result","注册成功！");
            map.put("message","无错误");
            Date date= getCurrentDate.getCurrentDate();
            Log log=new Log(1,mapHttpHeader.get("ip"),date,"regist",mapHttpHeader.get("url"),mapHttpHeader.get("user-agent"));
            logMapper.insertLog(log);
            User u=userMapper.selectByPhone(user.getPhone());
            String hPUrl="http://223.3.70.34:8080/head_portrait/baidu.png";
            userInforMapper.insertUserInfor(1,u.getId(),hPUrl);
            return map;
        }
        else{
            map.put("result","注册失败！");
            map.put("message","信息已存在");
            return map;
        }

    }
}
