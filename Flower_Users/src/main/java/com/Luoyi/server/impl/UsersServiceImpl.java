package com.Luoyi.server.impl;

import com.Luoyi.bean.User;
import com.Luoyi.mapper.UserMapper;
import com.Luoyi.server.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
