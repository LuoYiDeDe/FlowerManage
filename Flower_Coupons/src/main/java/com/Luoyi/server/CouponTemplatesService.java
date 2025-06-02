package com.Luoyi.server;

import com.Luoyi.bean.CouponTemplates;

import java.util.List;

public interface CouponTemplatesService {

    public List<CouponTemplates> getAllCouponT();

    public void addCouponT(CouponTemplates couponTemplates);

    public void updateCouponT(CouponTemplates couponTemplates);

}
