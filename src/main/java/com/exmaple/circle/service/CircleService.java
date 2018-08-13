package com.exmaple.circle.service;

import com.exmaple.circle.bean.UserCircleBean;
import com.exmaple.circle.mapper.CircleMapper;
import com.exmaple.circle.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircleService {
    private CircleMapper circleMapper;
    @Autowired
    public CircleService(CircleMapper circleMapper) {
        this.circleMapper = circleMapper;
    }
    public boolean sendMessage(Circle circle){
        return circleMapper.sendMessage(circle);
    }

    public boolean pariseMessage(UserCircleBean userCircleBean){
        return circleMapper.pariseMessage(userCircleBean);
    }

    public Circle selectCircleById(Integer id){
        Circle circle = new Circle();
        circle.setId(id);
        return circleMapper.selectCircleById(circle);
    }
}
