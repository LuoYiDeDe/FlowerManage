package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointsExchange implements Serializable {
    private Integer id;          // 记录ID
    private Integer userId;      // 用户ID
    private Integer productId;   // 商品ID
    private Integer exchangePoints; // 消耗积分
    private String exchangeTime; // 兑换时间
    private Integer status;      // 状态：0=待处理，1=已发货，2=已完成
    private String trackingNumber; // 物流单号
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}