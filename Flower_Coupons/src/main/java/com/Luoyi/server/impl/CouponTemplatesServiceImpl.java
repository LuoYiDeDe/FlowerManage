package com.Luoyi.server.impl;

import com.Luoyi.bean.CouponTemplates;
import com.Luoyi.mapper.CouponTemplatesMapper;
import com.Luoyi.server.CouponTemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponTemplatesServiceImpl implements CouponTemplatesService {

    @Autowired
    private CouponTemplatesMapper couponTemplatesMapper;

    /*
     * @Description: 获取所有优惠劵
     * @param
     * @return java.util.List<com.Luoyi.bean.CouponTemplates>
     * @Author: 落一.
     * @Date: 2025/5/28 19:57
     */
    @Override
    public List<CouponTemplates> getAllCouponT() {
        List<CouponTemplates> couponTemplatesMappers = couponTemplatesMapper.selectAll();
        return couponTemplatesMappers;
    }
    /*
     * @Description: 添加优惠券
     * @param couponTemplates
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/28 20:01
     */
    @Override
    public void addCouponT(CouponTemplates couponTemplates) {
        couponTemplatesMapper.insert(couponTemplates);
    }
    /*
     * @Description: 修改优惠劵
     * @param couponTemplates
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/28 20:02
     */
    @Override
    public void updateCouponT(CouponTemplates couponTemplates) {
        couponTemplatesMapper.update(couponTemplates);
    }


}
