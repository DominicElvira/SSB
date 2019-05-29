package com.school.ssb.service;

import com.school.ssb.bean.User;

public interface UserService {
    int addUser(String schoolNo, String password, String nickName);

    User getUserByParams(String schoolNo, String password);

    User selectById(Long id);
}
