package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointsProducts implements Serializable {
    private Integer id; // 商品ID，自增主键
    private String name; // 商品名称
    private String description; // 商品详细描述
    private Integer pointsRequired; // 兑换所需积分
    private Integer stock; // 库存数量
    private String category; // 商品分类
    private String imageUrl; // 商品图片URL
    private Integer status; // 商品状态：1=上架，0=下架
    private String createdAt; // 商品上架时间

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}