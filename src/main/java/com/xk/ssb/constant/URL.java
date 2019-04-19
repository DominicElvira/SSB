package com.xk.ssb.constant;

/**
 * @Auther: 谢凯
 * @Date: 2019/4/18 17:42
 * @Description:
 */
public enum URL {
    YNU("http://ids.ynu.edu.cn/authserver/login","POST"),
    YNUINDEX("http://ids.ynu.edu.cn/authserver/index.do","GET");
    private String value;
    private String method;

    URL(String value, String method) {
        this.method = method;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getMethod() {
        return method;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
