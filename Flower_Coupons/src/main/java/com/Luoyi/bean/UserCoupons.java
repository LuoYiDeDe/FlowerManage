package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCoupons implements Serializable {
    private Integer id;             // 用户优惠券ID，自增主键
    private Integer templateId;     // 关联优惠券模板ID
    private Integer userId;         // 关联用户ID
    private String couponCode;      // 优惠券码，唯一标识
    private Integer isUsed;         // 使用状态：0=未使用，1=已使用
    private String obtainedTime;    // 获取时间

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}