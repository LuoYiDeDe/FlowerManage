package com.Luoyi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MyCouponsService")
public interface CouponsFeignClient {

    @PostMapping("/coupon/usecoupon")
    void usedCoupons(@RequestBody Integer id);


}
