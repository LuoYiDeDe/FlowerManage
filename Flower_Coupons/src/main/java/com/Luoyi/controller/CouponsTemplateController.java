package com.Luoyi.controller;

import com.Luoyi.bean.CouponTemplates;
import com.Luoyi.bean.Result;
import com.Luoyi.server.CouponTemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupont")
public class CouponsTemplateController {

    @Autowired
    private CouponTemplatesService couponTemplatesService;
    /*
     * @Description: 获取所有优惠劵
     * @param
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 20:04
     */
    @RequestMapping("/getallcoupont")
    public Result getAllCouponT(){
        return Result.success(couponTemplatesService.getAllCouponT());
    }
    /*
     * @Description: 修改优惠券
     * @param couponTemplates
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 20:06
     */
    @RequestMapping("/updatecoupont")
    public Result updateCoupont(@RequestBody CouponTemplates couponTemplates){
        couponTemplatesService.updateCouponT(couponTemplates);
        return Result.success();
    }
    /*
     * @Description: 添加优惠券
     * @param couponTemplates
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 20:06
     */
    @RequestMapping("/addcoupont")
    public Result addCoupont(@RequestBody CouponTemplates couponTemplates){
        couponTemplatesService.addCouponT(couponTemplates);
        return Result.success();
    }

}
