package com.xk.ssb.service;

import com.xk.ssb.bean.User;

public interface UserService {
    int addUser(String schoolNo, String password, String nickName);

    User getUserByParams(String schoolNo, String password);
}
