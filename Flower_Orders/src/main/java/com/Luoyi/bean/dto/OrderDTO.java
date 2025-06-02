package com.Luoyi.bean.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private Integer userId;
    private String orderNo;
    private BigDecimal totalAmount;
    private Integer payStatus;
    private Integer orderStatus;
    private String address;
    private String createdAt;
    private String payTime;
    //明细
    private Integer productId;  // 关联商品ID
    private Integer quantity;   // 购买数量
    private Double price;       // 购买单价（下单时的商品价格）
    //优惠劵id
    private Integer couponId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
