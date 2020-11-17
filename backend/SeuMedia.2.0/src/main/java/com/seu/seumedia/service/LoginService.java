package com.seu.seumedia.service;

import com.seu.seumedia.entity.User;

import java.util.Map;

public interface LoginService {
    String login(String username, String password, String userStatus, int mod, Map<String, String> mapHttpHeader) throws Exception;
    String selectById(long id);
    User login(String username, String password, int mod, Map<String, String> mapHttpHeader) throws Exception;

}
