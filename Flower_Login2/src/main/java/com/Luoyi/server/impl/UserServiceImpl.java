package com.Luoyi.server.impl;

import com.Luoyi.bean.User;
import com.Luoyi.mapper.UserMapper;
import com.Luoyi.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        User user = userMapper.queryUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public boolean register(String username, String password,String phone) {
        User user = userMapper.queryUserByUsername(username);

        if (user == null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            int tr = userMapper.insertUser(user);
            if (tr > 0) {
                return true;
            }
        }

        return false;
    }
    /*
     * @Description: 商家登录
     * @param user
     * @return com.Luoyi.bean.User
     * @Author: 落一.
     * @Date: 2025/5/28 14:25
     */
    @Override
    public User adminlogin(User user) {
        User adminlogin = userMapper.adminlogin(user.getUsername(), user.getPassword());
        return adminlogin;
    }
}
