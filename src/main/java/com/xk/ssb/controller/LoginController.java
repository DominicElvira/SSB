package com.xk.ssb.controller;

import com.xk.ssb.bean.User;
import com.xk.ssb.service.LoginService;
import com.xk.ssb.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
