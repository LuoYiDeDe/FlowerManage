package com.Luoyi.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private Integer id;
    private String orderNo;
    private BigDecimal totalAmount;
    private Integer orderStatus; //订单状态：0=待发货，1=已发货，2=已完成
    private Integer quantity;  // 购买数量
    private String image;
    private String orderName;
    private String createdAt;
 }
