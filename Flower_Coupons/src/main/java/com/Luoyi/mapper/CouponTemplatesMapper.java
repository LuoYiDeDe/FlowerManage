package com.Luoyi.mapper;

import com.Luoyi.bean.CouponTemplates;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CouponTemplatesMapper {

    @Insert("INSERT INTO coupon_templates(title, type, discount_value, min_amount) " +
            "VALUES(#{title}, #{type}, #{discountValue}, #{minAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(CouponTemplates template);

    @Delete("DELETE FROM coupon_templates WHERE id = #{id}")
    int deleteById(Integer id);

    @Update("UPDATE coupon_templates SET " +
            "title = #{title}, " +
            "type = #{type}, " +
            "discount_value = #{discountValue}, " +
            "min_amount = #{minAmount} " +
            "WHERE id = #{id}")
    int update(CouponTemplates template);

    @Select("SELECT * FROM coupon_templates WHERE id = #{id}")
    CouponTemplates selectById(Integer id);

    @Select("SELECT * FROM coupon_templates")
    List<CouponTemplates> selectAll();
}