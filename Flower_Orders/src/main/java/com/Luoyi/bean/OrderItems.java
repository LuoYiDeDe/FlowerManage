package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems implements Serializable {
    private Integer id;         // 明细ID，自增主键
    private Integer orderId;    // 关联订单ID
    private Integer productId;  // 关联商品ID
    private Integer quantity;   // 购买数量
    private Double price;       // 购买单价（下单时的商品价格）

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}