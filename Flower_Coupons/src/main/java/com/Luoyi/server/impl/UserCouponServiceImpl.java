package com.Luoyi.server.impl;

import com.Luoyi.bean.CouponTemplates;
import com.Luoyi.bean.UserCoupons;
import com.Luoyi.bean.vo.CouponDTO;
import com.Luoyi.bean.vo.CouponVO;
import com.Luoyi.mapper.CouponTemplatesMapper;
import com.Luoyi.mapper.UserCouponMapper;
import com.Luoyi.server.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserCouponServiceImpl implements UserCouponService {

    @Autowired
    private CouponTemplatesMapper couponTemplatesMapper;
    @Autowired
    private UserCouponMapper userCouponMapper;
    /*
     * @Description: 添加优惠劵
     * @param couponDTO
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/27 14:42
     */
    @Override
    public void addCoupon(CouponDTO couponDTO) {
        //创建随机优惠劵码
        String uuid = UUID.randomUUID().toString().substring(0, 10);
        //封装
        UserCoupons userCoupons = new UserCoupons();
        userCoupons.setUserId(couponDTO.getUserId());
        userCoupons.setTemplateId(couponDTO.getTemplateId());
        userCoupons.setCouponCode(uuid);
        //插入对应用户
        userCouponMapper.insert(userCoupons);
    }
    /*
     * @Description: 使用优惠劵
     * @param userCoupons
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/27 14:42
     */
    @Override
    public void useCoupon(Integer id) {
        //修改使用状态
        userCouponMapper.updateIsUsed(id);
    }
    /*
     * @Description: 获取用户优惠券
     * @param userId
     * @return java.util.List<com.Luoyi.bean.vo.CouponVO>
     * @Author: 落一.
     * @Date: 2025/5/27 14:43
     */
    @Override
    public List<CouponVO> getCoupon(Integer userId) {
        List<CouponVO> couponVOList = new ArrayList<>();
        //获取用户可用优惠劵列表
        List<UserCoupons> userCoupons = userCouponMapper.selectByUserid(userId);
        //取出优惠劵模板信息
        for (UserCoupons userCoupon : userCoupons) {
            CouponTemplates couponTemplates = couponTemplatesMapper.selectById(userCoupon.getTemplateId());
            //封装VO
            CouponVO couponVO = new CouponVO(userCoupon.getId(),couponTemplates.getTitle(),couponTemplates.getType(),
                    couponTemplates.getDiscountValue(),couponTemplates.getMinAmount(),userCoupon.getObtainedTime(),
                    userCoupon.getCouponCode());
            //存入列表
            couponVOList.add(couponVO);
        }
        //返回
        return couponVOList;
    }
}
