package com.exmaple.circle.bean;

import java.util.List;

public class UserCircleBean {
    /*朋友圈推送信息*/
    private String circleMessage;
    /*点赞者id*/
    private Integer userId;
    /*推送信息id*/
    private Integer circleId;
    /*总点赞数*/
    private Integer pariseCount;
    /*点赞者id列表*/
    private String pariseIds;

    public String getCircleMessage() {
        return circleMessage;
    }

    public void setCircleMessage(String circleMessage) {
        this.circleMessage = circleMessage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getPariseCount() {
        return pariseCount;
    }

    public void setPariseCount(Integer pariseCount) {
        this.pariseCount = pariseCount;
    }

    public String getPariseIds() {
        return pariseIds;
    }

    public void setPariseIds(String pariseIds) {
        this.pariseIds = pariseIds;
    }
}
