package com.exmaple.circle.controller;

import com.exmaple.circle.model.User;
import com.exmaple.circle.service.UserService;
import com.xk.common.thirdparty.qcloud.utilities.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Object add(@RequestBody User user) {
        if (userService.findByName(user.getName()) != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message","用户名已被使用");
            return jsonObject;
        }
        return userService.add(user);
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object hello() {
       return "the first";
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("/loginUser")
    public Object loginUser(@RequestBody User user){
        User u = userService.findByName(user.getName());
        if(u != null){
            if(u.getPassword().equals(user.getPassword())){
                if(u.getStatus()!=1&&u.getStatus()!=3){
                    u.setStatus(2);
                    boolean success = userService.updateUserStatus(u);
                    if(success){
                        return user;
                    }
                }else if(u.getStatus()==3){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("message","该用户已登录！");
                }
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","账号或密码错误");
        return jsonObject;
    }

    /**
     * 退出登录
     * @param user
     * @return
     */
    @PostMapping("/loginOut")
    public Object loginOut(@RequestBody User user){
        User u = userService.findByName(user.getName());
        if(u != null){
          if(u.getStatus()==2){
              u.setStatus(3);
              boolean success = userService.updateUserStatus(u);
              if(success){
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("message","已经安全退出");
                  return jsonObject;
              }
          }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","退出失败");
        return jsonObject;
    }
}