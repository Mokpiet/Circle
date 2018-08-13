package com.exmaple.circle.service;

import com.exmaple.circle.mapper.UserMapper;
import com.exmaple.circle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User add(User user) {
        userMapper.addUser(user);
        return findById(user.getId());
    }

    public User findById(int id) {
        User user = new User();
        user.setId(id);
        return userMapper.findUser(user);
    }

    public User findByName(String name) {
        User param = new User();
        param.setName(name);
        return userMapper.findUser(param);
    }

    public boolean updateUserStatus(User user){
        return userMapper.updateUserStatus(user);
    }
}

