package com.Luoyi.bean.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointsExchangeVO implements Serializable {

    private String trackingNumber; // 物流单号
    private String pointProductName; //名称
    private Integer exchangePoints; // 消耗积分
    private String exchangeTime; // 兑换时间
    private Integer status;      // 状态：0=待处理，1=已发货，2=已完成

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
