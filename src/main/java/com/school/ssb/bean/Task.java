package com.school.ssb.bean;

import java.util.Date;

public class Task extends BaseEntity{
    private Long id;

    private Long userid;

    private Integer tasktype;

    private Integer taskpattern;

    private String contentPublic;

    private String contentPrivate;

    private String imgSrc;

    private String address;

    private Date deadline;

    private Integer taskStatus;

    private Long executeUserid;

    private Date cerateTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getTasktype() {
        return tasktype;
    }

    public void setTasktype(Integer tasktype) {
        this.tasktype = tasktype;
    }

    public String getContentPublic() {
        return contentPublic;
    }

    public void setContentPublic(String contentPublic) {
        this.contentPublic = contentPublic == null ? null : contentPublic.trim();
    }

    public String getContentPrivate() {
        return contentPrivate;
    }

    public void setContentPrivate(String contentPrivate) {
        this.contentPrivate = contentPrivate == null ? null : contentPrivate.trim();
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getExecuteUserid() {
        return executeUserid;
    }

    public void setExecuteUserid(Long executeUserid) {
        this.executeUserid = executeUserid;
    }

    public Date getCerateTime() {
        return cerateTime;
    }

    public void setCerateTime(Date cerateTime) {
        this.cerateTime = cerateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTaskpattern(){ return  taskpattern;}

    public void  setTaskpattern(Integer taskpattern){this.taskpattern = taskpattern;}
}