package com.seu.seumedia.mapper;

import com.seu.seumedia.entity.Log;
import com.seu.seumedia.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogMapper {
    int insertLog(Log log);
    int deleteLog(long id);
    int updateById(long id);
    User selectById(long id);
}
