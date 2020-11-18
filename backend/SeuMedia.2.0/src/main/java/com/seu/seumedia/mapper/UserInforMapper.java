package com.seu.seumedia.mapper;

import com.seu.seumedia.entity.UserInfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInforMapper {

    UserInfor selectById(@Param("Id") long id);
    int delete(long id);
    //String selectHpById(@Param("Id") long id);
    int insertUserInfor(long id, @Param("userId") long user_id,@Param("hPUrl") String hPUrl);/*@Param("userId") 要和UserInforMapper.xml文件里的SQL语句变量对应；*/
    int updateHpById(@Param("Id") long id, @Param("head_portrait") String head_portrait);
}
