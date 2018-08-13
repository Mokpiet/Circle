package com.exmaple.circle.mapper;

import com.exmaple.circle.model.User;

public interface UserMapper {
    int addUser(User user);
    User findUser(User user);
    boolean updateUserStatus(User user);
}
