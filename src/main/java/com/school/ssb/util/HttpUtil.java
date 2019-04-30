package com.school.ssb.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Auther: 谢凯
 * @Date: 2019/4/18 18:25
 * @Description:
 */
public class HttpUtil {
    private HttpUtil(){};

    public static int doPost(CookieStore cookiestore, String url,Map<String,String> variableParams) {
        int status = 0;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpClient.setCookieStore(cookiestore);
        httpPost.addHeader("charset", HTTP.UTF_8);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        variableParams.forEach((k,v)->{
            NameValuePair nameValuePair = new BasicNameValuePair(k, v);
            nameValuePairList.add(nameValuePair);
        });
        UrlEncodedFormEntity httpEntity = null;
        try {
            httpEntity = new UrlEncodedFormEntity(nameValuePairList);
            httpPost.setEntity(httpEntity);
            HttpResponse httpResponse = null;
            httpResponse = httpClient.execute(httpPost);
            cookiestore=httpClient.getCookieStore();
            status = httpResponse.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static String getDocString(HttpResponse httpResponse) {
        String result = "";
        HttpEntity httpEntity = httpResponse.getEntity();
        try {
            result = EntityUtils.toString(httpEntity);// 取出应答字符串
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.replaceAll("\r", "");// 去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
        return result;
    }



}
