package com.xk.ssb.bean;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private Long id;

    private String username;

    private String password;

    private Integer userSex;

    private String nickName;

    private Timestamp cerateTime;

    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Date getCerateTime() {
        return cerateTime;
    }

    public void setCerateTime(Timestamp cerateTime) {
        this.cerateTime = cerateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public User(String username, String password, Integer userSex) {
        this.username = username;
        this.password = password;
        this.userSex = userSex;
    }

    public User(Long id, String username, String password, Integer userSex, String nickName, Timestamp cerateTime, Timestamp updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userSex = userSex;
        this.nickName = nickName;
        this.cerateTime = cerateTime;
        this.updateTime = updateTime;
    }
}