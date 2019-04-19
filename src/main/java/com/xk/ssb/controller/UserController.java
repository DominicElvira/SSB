package com.xk.ssb.controller;

import com.xk.ssb.bean.User;
import com.xk.ssb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public List<String> hello() {
        List<String> helloList = new ArrayList<>();
        helloList.add("hello");
        helloList.add("worlds");
        return helloList;
    }
}
