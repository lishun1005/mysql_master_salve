package com.lishun.entity;

import java.util.Date;

public class WmIpInfo {
    private String id;

    private String cityId;

    private Integer infoHour;

    private Integer infoCount;

    private Date createTime;

    private String ipAddr;

    private Date infoDay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Integer getInfoHour() {
        return infoHour;
    }

    public void setInfoHour(Integer infoHour) {
        this.infoHour = infoHour;
    }

    public Integer getInfoCount() {
        return infoCount;
    }

    public void setInfoCount(Integer infoCount) {
        this.infoCount = infoCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getInfoDay() {
        return infoDay;
    }

    public void setInfoDay(Date infoDay) {
        this.infoDay = infoDay;
    }
}