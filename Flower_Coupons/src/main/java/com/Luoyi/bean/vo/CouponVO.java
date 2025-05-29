package com.Luoyi.bean.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponVO implements Serializable {
    private Integer id;             // 用户优惠券ID，自增主键
    //'优惠券标题（如"满100减20"）'
    private String title;
    //'优惠券类型：0=满减，1=打折'
    private int type;
    //'折扣值：满减金额或折扣比例（如20.00或0.8）'
    private double discountValue;
    //'最低消费金额（如100.00表示满100可用）'
    private double minAmount;
    private String obtainedTime;    // 获取时间
    private String couponCode;      // 优惠券码，唯一标识

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
