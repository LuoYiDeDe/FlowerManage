package com.Luoyi.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {
    private Integer templateId;     // 关联优惠券模板ID
    private Integer userId;         // 关联用户ID
}
