package com.Luoyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
 * @Description: 分页返回类
 * @Author: 落一.
 * @Date: 2025/6/4 9:33
 */
public class PageReuslt<T> {
    private List<T> list;           // 当前页数据
    private Integer pageNum;        // 当前页码
    private Integer pageSize;       // 每页数量
    private Long total;            // 总记录数
    private Integer pages;         // 总页数
}
