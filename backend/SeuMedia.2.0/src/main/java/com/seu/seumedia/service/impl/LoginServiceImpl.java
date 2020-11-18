package com.seu.seumedia.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.seu.seumedia.service.LoginService;
import com.seu.seumedia.entity.Log;
import com.seu.seumedia.entity.User;
import com.seu.seumedia.mapper.LogMapper;
import com.seu.seumedia.mapper.UserInforMapper;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.utils.HashCode;
import com.seu.seumedia.utils.getCurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService{


    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    LogMapper logMapper;
    @Autowired(required = false)
    UserInforMapper userInforMapper;

    public String login(String username, String password, String userStatus, int mod, Map<String, String> mapHttpHeader) throws Exception {
        Map<String, String> map = new HashMap<>();
        Date newDate = getCurrentDate.getCurrentDate();
        if (mod == 0)/*电话登录*/ {
            User currentUser = userMapper.selectByPhone(username);

            if (currentUser == null) {
                map.put("result", "登录失败");
                map.put("message", "当前用户名不在，请注册");
                map.put("status", "0");
                //return map;
                return null;
            } else if (HashCode.getHashCode(password).equals(currentUser.getPassword()) && userStatus.equals(currentUser.getUserStatus())) {
                map.put("result", "登录成功");
                map.put("message", "无错误");
                map.put("status", "1");
                Log log = new Log(1, mapHttpHeader.get("ip"), newDate, "login by phone", mapHttpHeader.get("url"), mapHttpHeader.get("user-agent"));
                long Id=currentUser.getId();
                String hP=userInforMapper.selectById(Id).getHeadPortrait(); //获得用户头像url
                logMapper.insertLog(log);

                JSONObject object = new JSONObject();
                object.put("id",currentUser.getId());
                object.put("username",currentUser.getUsername());
                object.put("password",currentUser.getPassword());
                object.put("phone",currentUser.getPhone());
                object.put("userStatus",currentUser.getUserStatus());
                object.put("createBy",currentUser.getCreateBy());
                object.put("email",currentUser.getEmail());
                object.put("idDeleted",currentUser.getIdDeleted());
                object.put("modifiedBy",currentUser.getModifiedBy());

                object.put("headPortrait",hP);
                return object.toJSONString();



            } else {
                map.put("result", "登录失败");
                map.put("message", "密码错误，请重试");
                map.put("status", "0");
                //return map;
                return null;

            }

        } else {/*email登录*/
            User currentUser = userMapper.selectByEmail(username);
            if (currentUser == null) {
                map.put("result", "登录失败");
                map.put("message", "当前用户名不在，请注册");
                map.put("status", "0");
                //return map;
                return null;
            } else if (HashCode.getHashCode(password).equals(currentUser.getPassword()) && userStatus.equals(currentUser.getUserStatus())) {
                map.put("result", "登录成功");
                map.put("message", "无错误");
                map.put("status", "1");
                Log log = new Log(1, mapHttpHeader.get("ip"), newDate, "login by email", mapHttpHeader.get("url"), mapHttpHeader.get("user-agent"));
                logMapper.insertLog(log);
                // return map;
                long Id=currentUser.getId();
                String hP=userInforMapper.selectById(Id).getHeadPortrait(); //获得用户头像url
                JSONObject object = new JSONObject();
                object.put("id",currentUser.getId());
                object.put("username",currentUser.getUsername());
                object.put("password",currentUser.getPassword());
                object.put("phone",currentUser.getPhone());
                object.put("userStatus",currentUser.getUserStatus());
                object.put("createBy",currentUser.getCreateBy());
                object.put("email",currentUser.getEmail());
                object.put("idDeleted",currentUser.getIdDeleted());
                object.put("modifiedBy",currentUser.getModifiedBy());

                object.put("headPortrait",hP);
                return object.toJSONString();
            } else {
                map.put("result", "登录失败");
                map.put("message", "密码错误，请重试");
                map.put("status", "0");
                //return map;
                return null;

            }

        }
    }

    public String selectById(long id) {
        User currentUser = userMapper.selectByPrimaryKey(id);
        String hP=userInforMapper.selectById(currentUser.getId()).getHeadPortrait(); //获得用户头像url
        JSONObject object = new JSONObject();
        object.put("id",currentUser.getId());
        object.put("username",currentUser.getUsername());
        object.put("password",currentUser.getPassword());
        object.put("phone",currentUser.getPhone());
        object.put("userStatus",currentUser.getUserStatus());
        object.put("createBy",currentUser.getCreateBy());
        object.put("email",currentUser.getEmail());
        object.put("idDeleted",currentUser.getIdDeleted());
        object.put("modifiedBy",currentUser.getModifiedBy());

        object.put("headPortrait",hP);
        return object.toJSONString();
    }

    public User login(String username, String password, int mod, Map<String, String> mapHttpHeader) throws Exception {
        Map<String, String> map = new HashMap<>();
        Date newDate = getCurrentDate.getCurrentDate();
        if (mod == 0)/*电话登录*/ {
            User currentUser = userMapper.selectByPhone(username);
            if (currentUser == null) {
                map.put("result", "登录失败");
                map.put("message", "当前用户名不在，请注册");
                map.put("status", "0");
                //return map;
                return null;
            } else if (HashCode.getHashCode(password).equals(currentUser.getPassword())) {
                map.put("result", "登录成功");
                map.put("message", "无错误");
                map.put("status", "1");
                Log log = new Log(1, mapHttpHeader.get("ip"), newDate, "login by phone", mapHttpHeader.get("url"), mapHttpHeader.get("user-agent"));
                logMapper.insertLog(log);
                // return map;
                return currentUser;

            } else {
                map.put("result", "登录失败");
                map.put("message", "密码错误，请重试");
                map.put("status", "0");
                //return map;
                return null;

            }

        } else {/*email登录*/
            User currentUser = userMapper.selectByEmail(username);
            if (currentUser == null) {
                map.put("result", "登录失败");
                map.put("message", "当前用户名不在，请注册");
                map.put("status", "0");
                //return map;
                return null;
            } else if (HashCode.getHashCode(password).equals(currentUser.getPassword())) {
                map.put("result", "登录成功");
                map.put("message", "无错误");
                map.put("status", "1");
                Log log = new Log(1, mapHttpHeader.get("ip"), newDate, "login by email", mapHttpHeader.get("url"), mapHttpHeader.get("user-agent"));
                logMapper.insertLog(log);
                // return map;
                return currentUser;
            } else {
                map.put("result", "登录失败");
                map.put("message", "密码错误，请重试");
                map.put("status", "0");
                //return map;
                return null;

            }

        }
    }


}