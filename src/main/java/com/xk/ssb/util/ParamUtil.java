package com.xk.ssb.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * @Auther: 谢凯
 * @Date: 2019/4/19 09:54
 * @Description:
 */
public class ParamUtil {
    private ParamUtil() { }

    public static int getIntValue(String v, int def) {
        try {
            return Integer.parseInt(v);
        } catch (Exception ex) {
            return def;
        }
    }

    public static String toString(Object s) {
        return s == null ? "" : s.toString();
    }

    public static String mapParamString(Map<String,Object> params, String param){
        return toString(params.get(param));
    }

    public static  Map<String,Object> toMap(Map<String,Object> params,String param){
        String map = toString(params.get(param));
        Map<String, Object> result = JSON.parseObject(map, new TypeReference<Map<String,Object>>(){});
        return result;
    }
}
