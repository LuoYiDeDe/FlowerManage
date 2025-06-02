package com.Luoyi.controller;

import com.Luoyi.bean.Result;
import com.Luoyi.bean.vo.CouponDTO;
import com.Luoyi.bean.vo.CouponVO;
import com.Luoyi.server.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class UserCouponsController {

    @Autowired
    private UserCouponService userCouponService;
    /*
     * @Description: 添加优惠劵
     * @param couponDTO
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/27 14:48
     */
    @PostMapping("/addcoupon")
    public Result add(@RequestBody CouponDTO couponDTO){
        userCouponService.addCoupon(couponDTO);
        return Result.success();
    }
    /*
     * @Description: 使用优惠券
     * @param userCoupons
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/27 14:48
     */
    @PostMapping("/usecoupon")
    public Result used(@RequestBody Integer id){
        userCouponService.useCoupon(id);
        return Result.success();
    }
    /*
     * @Description: 获取用户可用优惠券
     * @param userId
     * @return com.Luoyi.bean.Result<java.util.List<com.Luoyi.bean.vo.CouponVO>>
     * @Author: 落一.
     * @Date: 2025/5/27 14:49
     */
    @GetMapping("/getcoupons")
    public Result<List<CouponVO>> getCoupons(Integer userId){
        List<CouponVO> coupon = userCouponService.getCoupon(userId);
        return Result.success(coupon);
    }


}
