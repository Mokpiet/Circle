package com.exmaple.circle.model;

import java.util.Date;
import java.util.List;

public class Circle {
    /*主键id*/
    private Integer id;
    /*创建人id（用户id）*/
    private Integer userId;
    /*朋友圈信息*/
    private String circleMessage;
    /*总点赞数*/
    private Integer pariseCount;
    /*创建日期*/
    private Date createDate;
    /*点赞人列表（Id）*/
    private String pariseIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCircleMessage() {
        return circleMessage;
    }

    public void setCircleMessage(String circleMessage) {
        this.circleMessage = circleMessage;
    }

    public Integer getPariseCount() {
        return pariseCount;
    }

    public void setPariseCount(Integer pariseCount) {
        this.pariseCount = pariseCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPariseIds() {
        return pariseIds;
    }

    public void setPariseIds(String pariseIds) {
        this.pariseIds = pariseIds;
    }
}
