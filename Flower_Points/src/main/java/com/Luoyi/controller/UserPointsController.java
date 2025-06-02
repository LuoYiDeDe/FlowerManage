package com.Luoyi.controller;

import com.Luoyi.bean.Result;
import com.Luoyi.bean.dto.UserPointsDTO;
import com.Luoyi.server.UserPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
public class UserPointsController {

    @Autowired
    private UserPointsService userPointsService;
    /*
     * @Description: 获取用户积分
     * @param id
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/31 10:13
     */
    @RequestMapping("/getuserpoints")
    public Result getUserPoints(@RequestBody Integer id){
        return Result.success(userPointsService.selectPointByUserId(id));
    }
    /*
     * @Description: 扣减积分
     * @param userPointsDTO
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/31 10:17
     */
    @RequestMapping("/updateuserpoints")
    public Result updateUserPoints(@RequestBody UserPointsDTO userPointsDTO){
        if(userPointsService.updatePoints(userPointsDTO) > 0){
            return Result.success();
        }else {
            return Result.fail("扣减积分失败");
        }

    }

}
