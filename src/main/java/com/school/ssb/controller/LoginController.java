package com.school.ssb.controller;

import com.school.ssb.service.LoginService;
import com.school.ssb.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: 谢凯
 * @Date: 2019/4/18 17:13
 * @Description:
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String,Object> doLogin(@RequestBody Map<String,Object> reqMap) {
        String userName = ParamUtil.mapParamString(reqMap, "userName");
        String password = ParamUtil.mapParamString(reqMap, "password");
        return loginService.doYnuLogin(userName, password);
    }

}
