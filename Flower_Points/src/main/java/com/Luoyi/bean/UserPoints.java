package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPoints implements Serializable {
    private Integer id;         // 记录ID
    private Integer userId;     // 用户ID
    private Integer availablePoints; // 可用积分
    private String createdAt;     // 创建时间
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}