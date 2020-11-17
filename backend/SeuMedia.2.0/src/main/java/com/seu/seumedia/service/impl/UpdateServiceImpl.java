package com.seu.seumedia.service.impl;

import com.seu.seumedia.mapper.UserInforMapper;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService{

    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    UserInforMapper userInforMapper;
    public boolean updateById(long id,String username,String password,String phone,String email,String picturePath){
        int result1=userMapper.updateById(id,username,password,phone,email);
        int result2=userInforMapper.updateHpById(id,picturePath);
        if(result1==1&&result2==1){
            return true;
        }else{
            return false;
        }
    }
    public boolean updateHpById(long id,String picturePath){
        if(userInforMapper.updateHpById(id,picturePath)==1){
            return true;
        }
        return false;
    }
}