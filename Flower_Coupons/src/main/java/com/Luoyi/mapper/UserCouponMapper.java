package com.Luoyi.mapper;

import com.Luoyi.bean.UserCoupons;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserCouponMapper {

    @Insert("INSERT INTO user_coupons(template_id, user_id, coupon_code, is_used, obtained_time) " +
            "VALUES(#{templateId}, #{userId}, #{couponCode}, 0, now())")
    public int insert(UserCoupons userCoupons);

    @Update("UPDATE user_coupons SET is_used = 1 WHERE id = #{id}")
    public int updateIsUsed(Integer id);

    @Select("SELECT * FROM user_coupons")
    public List<UserCoupons> selectAll();

    @Select("SELECT * FROM user_coupons WHERE user_id = #{userId} and is_used = 0")
    public List<UserCoupons> selectByUserid(Integer userId);


}
