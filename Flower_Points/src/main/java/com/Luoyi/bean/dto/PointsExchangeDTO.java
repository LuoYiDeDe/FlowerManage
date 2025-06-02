package com.Luoyi.bean.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointsExchangeDTO implements Serializable {
    private Integer id; // 商品ID，自增主键
    private Integer stock; // 商品库存数量
    private Integer userId; //用户id
    private Integer availablePoints; //可用积分
    private Integer points; //消耗积分

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
