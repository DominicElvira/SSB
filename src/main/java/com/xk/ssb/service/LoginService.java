package com.xk.ssb.service;

import java.util.Map;

/**
 * @Auther: 谢凯
 * @Date: 2019/4/18 17:23
 * @Description:
 */
public interface LoginService {
    public Map<String,Object> doYnuLogin(String schoolNo, String password);
}
