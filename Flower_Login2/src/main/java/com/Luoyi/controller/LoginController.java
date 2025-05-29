package com.Luoyi.controller;

import com.Luoyi.bean.Result;
import com.Luoyi.bean.User;
import com.Luoyi.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private int port;


    /*
     * @Description:
     * @param username
     * @param password
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/19 20:11
     */
    @RequestMapping(value = "/login")
    public Result getLogin(@RequestParam String username,@RequestParam String password){
        User user = userService.login(username, password);
        if (user == null) {
            return Result.fail(400,"用户名或密码错误");
        }
        return Result.success(user);
    }
    /*
     * @Description: 用户注册
     * @param username
     * @param password
     * @param phone
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 14:41
     */
    @RequestMapping("/register")
    public Result register(String username,String password,String phone){
        if(userService.register(username,password,phone)){
            return Result.success();
        }else {
            return Result.fail("用户名已被占用，请从新输入用户名~");
        }
    }
    /*
     * @Description: 商家登录
     * @param user
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 14:41
     */
    @RequestMapping("/adminlogin")
    public Result adminLogin(@RequestParam String username,@RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User adminlogin = userService.adminlogin(user);
        if (user == null) {
            return Result.fail(400,"用户名或密码错误");
        }
        return Result.success(adminlogin);
    }

}
