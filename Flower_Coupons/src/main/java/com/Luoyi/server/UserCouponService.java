package com.Luoyi.server;

import com.Luoyi.bean.vo.CouponDTO;
import com.Luoyi.bean.vo.CouponVO;

import java.util.List;

public interface UserCouponService {

    public void addCoupon(CouponDTO couponDTO);

    public void useCoupon(Integer id);

    public List<CouponVO> getCoupon(Integer userId);

}
