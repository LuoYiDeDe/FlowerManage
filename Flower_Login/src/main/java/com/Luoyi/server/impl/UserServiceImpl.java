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
    /*
     * @Description: 用户登录
     * @param username
     * @param password
     * @return com.Luoyi.bean.User
     * @Author: 落一.
     * @Date: 2025/5/28 10:20
     */
    @Override
    public User login(String username, String password) {
        User user = userMapper.queryUserByUsernameAndPassword(username, password);
        return user;
    }
    /*
     * @Description: 注册用户
     * @param username
     * @param password
     * @param phone
     * @return boolean
     * @Author: 落一.
     * @Date: 2025/5/28 10:20
     */
    @Override
    public boolean register(String username, String password,String phone) {
        User user = userMapper.queryUserByUsername(username);

        if (user == null) {
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            user1.setPhone(phone);
            //普通用户，普通会员
            user1.setRole(0);
            user1.setLevel(0);
            int tr = userMapper.insertUser(user1);
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
