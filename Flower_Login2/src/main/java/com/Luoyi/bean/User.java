package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;         // 用户ID，自增主键
    private String username;    // 用户名，唯一标识
    private String password;    // 用户密码
    private String phone;       // 手机号，用于登录和联系
    private Integer role;       // 用户角色：0=普通用户，1=管理员
    private Integer level;      // 会员等级：0=普通会员，1=黄金会员

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}



