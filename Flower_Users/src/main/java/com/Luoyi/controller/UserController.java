package com.Luoyi.controller;

import com.Luoyi.bean.Result;
import com.Luoyi.bean.User;
import com.Luoyi.server.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;
    /*
     * @Description: 获取所有用户
     * @param
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 19:37
     */
    @RequestMapping("/getalluser")
    public Result getAllUsers(){
        return Result.success(usersService.getAllUsers());
    }
    /*
     * @Description: 修改用户信息
     * @param user
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 19:38
     */
    @PostMapping("/updateuser")
    public Result updateUser(@RequestBody User user){
        usersService.updateUser(user);
        return Result.success();
    }

}
