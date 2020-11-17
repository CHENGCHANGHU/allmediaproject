package com.seu.seumedia.entity;

import java.util.Date;

public class Log {
    private long id;
    private String ip;
    private Date createTime;
    private String remark;
    private String operateUrl;
    private String operateBy;

    public Log(long id, String ip, Date createTime, String remark, String operateUrl, String operateBy) {
        this.id = id;
        this.ip = ip;
        this.createTime = createTime;
        this.remark = remark;
        this.operateUrl = operateUrl;
        this.operateBy = operateBy;
    }

    public Log() {

    }

    public long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getIp() {
        return ip;
    }

    public String getOperateUrl() {
        return operateUrl;
    }

    public String getRemark() {

        return remark;
    }

    public String getOperateBy() {
        return operateBy;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl;
    }

    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy;
    }
}
