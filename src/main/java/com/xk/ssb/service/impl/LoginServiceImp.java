package com.xk.ssb.service.impl;

import com.xk.ssb.bean.User;
import com.xk.ssb.constant.URL;
import com.xk.ssb.service.LoginService;
import com.xk.ssb.service.UserService;
import com.xk.ssb.util.HttpUtil;
import com.xk.ssb.util.ParamUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 谢凯
 * @Date: 2019/4/18 17:39
 * @Description:
 */
@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    UserService userService;

    private static Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
    static CookieStore cookiestore = null;

    @Override
    public Map<String,Object> doYnuLogin(String schoolNo, String password) {
        Map<String, Object> result = new HashMap<>();
        String status = "0";
        User user = null;
        user = userService.getUserByParams(schoolNo, password);
        if (user != null) {
            Long id = user.getId();
            status = "1";
            result.put("id", id);
        }else {
            status = getYnuIndex(schoolNo, password);
            if ("302".equals(status)){//登录成功
                String nickName = getName(cookiestore);
                if (StringUtils.isNotBlank(nickName)) {
                    userService.addUser(schoolNo, password, nickName);
                    user = userService.getUserByParams(schoolNo, password);//后续再改
                    if (user != null) {
                        result.put("id", user.getId());
                    }
                }
                status = "1";
            }else {
                status = "0";
            }
        }
        result.put("status", status);

        return result;
    }

    /*
        模拟登录首页
     */
    public String getYnuIndex(String schoolNo, String password) {
        String result = "";
        HttpGet httpRequst = new HttpGet(URL.YNU.getValue());
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //1.第一次进入首页
        try {
            HttpResponse httpResponse = httpClient.execute(httpRequst);// 其中HttpGet是HttpUriRequst的子类
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                cookiestore = httpClient.getCookieStore();
                result = HttpUtil.getDocString(httpResponse);
            } else {
                httpRequst.abort();
            }
        } catch (Exception e) {
            logger.warn("getYnuIndex", e);
        }

        if (StringUtils.isNotBlank(result)) {
            Map<String, String> variableParam = getVariableParam(result);//2.拿到form表单的动态参数
            variableParam.put("username", schoolNo);
            variableParam.put("password", password);
            variableParam.put("dllt", "userNamePasswordLogin");
            variableParam.put("_eventId", "submit");
            variableParam.put("rmShown", "1");
            result =  ParamUtil.toString(doPost(variableParam, cookiestore));//3.提交表单,获取状态响应码
        }

        return result;
    }

    /*
        获取动态参数：lt、execution
     */
    public Map<String,String> getVariableParam(String response){
        Map<String, String> resultMap = new HashMap<>();
        Document document = Jsoup.parse(response);
        String lt = "";
        String execution = "";
        if (document != null) {
            lt = document.select("[name=lt]").attr("value");
            execution = document.select("[name=execution]").attr("value");
        }
        resultMap.put("lt", lt);
        resultMap.put("execution", execution);

        return resultMap;
    }

    /*
        提交表单，302：登录成功，202：登录失败
     */
    public int doPost(Map<String, String> formParam, CookieStore cookieStore) {
        int status = HttpUtil.doPost(cookieStore, URL.YNU.getValue(), formParam);
        return status;
    }

    public String getName(CookieStore cookieStore) {
        HttpGet httpRequst = new HttpGet(URL.YNUINDEX.getValue());
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.setCookieStore(cookiestore);
        String result = "";
        String name = "";
        Document doc = null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpRequst);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = HttpUtil.getDocString(httpResponse);
            } else {
                httpRequst.abort();
            }

            //解析HTML
            doc = Jsoup.parse(result);
            if (doc != null) {
                Elements elements = doc.select("[class=auth_siderbar][id=auth_siderbar]");
                Elements spans = elements.select("span");
                name = spans.first().text();
            }
        } catch (Exception e) {
            logger.warn("getName", e);
            e.printStackTrace();
        }
        return name;
    }

}
