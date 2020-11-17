package com.seu.seumedia.service;

public interface UpdateService {
    boolean updateById(long id,String username,String password,String phone,String email,String picturePath);
    boolean updateHpById(long id,String picturePath);
}
