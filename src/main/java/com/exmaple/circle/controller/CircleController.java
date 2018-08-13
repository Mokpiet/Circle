package com.exmaple.circle.controller;

import com.exmaple.circle.bean.UserCircleBean;
import com.exmaple.circle.model.Circle;
import com.exmaple.circle.service.CircleService;
import com.xk.common.thirdparty.qcloud.utilities.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("model/circle")
public class CircleController {
    private CircleService circleService;

    @Autowired
    public CircleController(CircleService circleService) {
        this.circleService = circleService;
    }

    /**
     * 推送一条朋友圈信息
     * @param circle
     * @return
     */
    @PostMapping("/sendMessage")
    public Object sendMessage(@RequestBody Circle circle){
        Date date = new Date();
//        DateFormat format = new SimpleDateFormat();
        circle.setCreateDate(date);
        boolean success = circleService.sendMessage(circle);
        if(!success){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message","推送朋友圈失败！");
        }
        return circle;
    }

    /**
     * 为朋友圈某条信息点赞
     * @param userCircleBean
     * @return
     */
    @PostMapping("/pariseMessage")
    public Object pariseMessage(@RequestBody UserCircleBean userCircleBean){
        JSONObject jsonObject = new JSONObject();
        if(userCircleBean.getCircleId()==null||userCircleBean.getUserId()==null){
            jsonObject.put("message","点赞信息失败！");
            return jsonObject;
        }
        Integer pariseCount = null;
        String pariseIds = null ;
        Circle circle = circleService.selectCircleById(userCircleBean.getCircleId());
        if(circle!=null) {
            if(circle.getPariseCount()!=null){
                pariseCount = circle.getPariseCount() + 1;
            }else {
                pariseCount = 1;
            }
            if(circle.getPariseIds()!=null){
                pariseIds = circle.getPariseIds()+","+userCircleBean.getUserId().toString();
            }else{
                pariseIds = userCircleBean.getUserId().toString();
            }
        }
        userCircleBean.setPariseCount(pariseCount);
        userCircleBean.setPariseIds(pariseIds);
        boolean success = circleService.pariseMessage(userCircleBean);
        if(!success){
            jsonObject.put("message","点赞信息失败！");
            return jsonObject;
        }
        return userCircleBean;
    }
}
