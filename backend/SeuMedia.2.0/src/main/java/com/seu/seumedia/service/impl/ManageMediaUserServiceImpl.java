package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.MediaUserInfo;
import com.seu.seumedia.mapper.LogMapper;
import com.seu.seumedia.mapper.UserInforMapper;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.service.ManageMediaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManageMediaUserServiceImpl implements ManageMediaUserService {

    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    LogMapper logMapper;
    @Autowired(required = false)
    UserInforMapper userInforMapper;

    public List<MediaUserInfo> getMediaUser(){
        return userMapper.selectMediaUser();
    }

    public boolean deleteMediaUserInfo(long id){
        if(userMapper.deleteMediaUserInfo(id)>0){
            return true;
        }else{
            return false;
        }
    }
}