package com.school.ssb.service.impl;

import com.school.ssb.bean.User;
import com.school.ssb.mapperDao.UserMapper;
import com.school.ssb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(String schoolNo, String password,String nickName) {

        User user = new User(schoolNo, password, nickName);
        user.setFlag(1);
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUserByParams(String schoolNo, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", schoolNo);
        paramMap.put("passWord", password);
        User user = userMapper.selectByParam(paramMap);
        return user;
    }

    @Override
    public User selectById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }




}
