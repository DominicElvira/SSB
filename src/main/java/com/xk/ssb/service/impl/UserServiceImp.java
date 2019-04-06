package com.xk.ssb.service.impl;

import com.xk.ssb.bean.User;
import com.xk.ssb.mapperDao.UserMapper;
import com.xk.ssb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser() {
        User user = new User("xk", "123456789",  0);
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1L);
    }

}
