package com.xk.ssb.controller;

import com.xk.ssb.bean.User;
import com.xk.ssb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add")
    public int addUser() {
        return userService.addUser();
    }

    @RequestMapping(value = "/get")
    public User getUser() {
        return userService.getUser();
    }
}
