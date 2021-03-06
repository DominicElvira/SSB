package com.school.ssb.mapperDao;

import com.school.ssb.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByParam(Map<String, Object> params);
}