package com.seu.seumedia.service;

import java.util.Map;

public interface UserInfoService {
    Map<String,Object> selectByPrimaryKey(long id);
}
