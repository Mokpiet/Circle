package com.exmaple.circle.mapper;

import com.exmaple.circle.bean.UserCircleBean;
import com.exmaple.circle.model.Circle;

public interface  CircleMapper {
    /*创建新的一条朋友圈信息*/
   Boolean sendMessage(Circle circle);
   /*为朋友圈信息点赞*/
   Boolean pariseMessage(UserCircleBean userCircleBean);
    /*根据id查询一条朋友圈信息*/
   Circle selectCircleById(Circle circle);
}
