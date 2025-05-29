package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
    private Integer id;
    private Integer userId;
    private String orderNo;
    private BigDecimal totalAmount;
    private Integer payStatus;
    private Integer orderStatus;
    private String address;
    private String createdAt;
    private String payTime;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}