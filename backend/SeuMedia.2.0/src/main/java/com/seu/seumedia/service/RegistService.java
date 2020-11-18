package com.seu.seumedia.service;

import com.seu.seumedia.entity.User;
import java.util.Map;

public interface RegistService {
    Map<String,String> regist(User user, Map<String,String> mapHttpHeader) throws Exception;
}
