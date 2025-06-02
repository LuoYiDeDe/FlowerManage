package com.Luoyi.bean.vo;

import lombok.Data;

@Data
//返回前端视图类
public class UserLoginVO {
    private String token;
    private Long userId;
    private String username;
}