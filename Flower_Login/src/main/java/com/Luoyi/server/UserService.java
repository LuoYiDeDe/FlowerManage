package com.Luoyi.server;


import com.Luoyi.bean.User;

public interface UserService {

    /*
     * @Description: 登录
     * @param username
     * @param password
     * @return boolean
     * @Author: 落一.
     * @Date: 2025/5/19 19:49
     */
    User login(String username, String password);

    /*
     * @Description: 注册
     * @param username
     * @param password
     * @return boolean
     * @Author: 落一.
     * @Date: 2025/5/19 19:49
     */
    boolean register(String username, String password,String phone);
    /*
     * @Description: 商家登录
     * @param user
     * @return com.Luoyi.bean.User
     * @Author: 落一.
     * @Date: 2025/5/28 14:25
     */
    User adminlogin(User user);

}
