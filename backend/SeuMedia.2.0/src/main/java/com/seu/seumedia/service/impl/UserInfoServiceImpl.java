package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.User;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired(required=false)
    private UserMapper userMapper;
    @Override
    public Map<String, Object> selectByPrimaryKey(long id) {
        User user=userMapper.selectByPrimaryKey(id);
        Map<String,Object> map=new HashMap<>();
        if(user!=null){
            map.put("result","success");
            map.put("username",user.getUsername());
            map.put("password",user.getPassword());

            return map;
        }
        else{
            map.put("result","fail");
            map.put("message","信息不存在");
            return map;
        }
    }
}
