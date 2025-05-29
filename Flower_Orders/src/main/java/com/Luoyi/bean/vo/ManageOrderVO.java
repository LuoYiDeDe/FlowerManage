package com.Luoyi.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageOrderVO implements Serializable {
    private int totalcount;
    private double totalprice;

}
