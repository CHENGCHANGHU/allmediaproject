package com.seu.seumedia.mapper;

import com.seu.seumedia.entity.MediaUserInfo;
import com.seu.seumedia.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
        User selectByPrimaryKey(long id);
        User  selectByPhone(String phone);
        User selectByEmail(String email);
        int insert(User user);
        int updateByPhone(String phone);
        int updateByEmail(String email);
        int updateById(@Param("Id") long id, @Param("username") String username, @Param("password") String password, @Param("phone") String phone, @Param("email") String email);
        List<MediaUserInfo> selectMediaUser();
        int deleteMediaUserInfo(@Param("Id") long id);

    }

