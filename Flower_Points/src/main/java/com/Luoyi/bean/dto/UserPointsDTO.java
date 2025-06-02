package com.Luoyi.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPointsDTO implements Serializable {
    private Integer userId; //用户id
    private Integer availablePoints; //可用积分
    private Integer points; //消耗积分
}
