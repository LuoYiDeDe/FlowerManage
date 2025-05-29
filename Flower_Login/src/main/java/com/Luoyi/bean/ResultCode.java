/**
 * ResultCode 枚举类定义了标准的HTTP状态码和对应的消息
 * 用于API响应结果。使用Lombok注解自动生成getter方法和全参构造器
 */
package com.Luoyi.bean;

import javafx.scene.input.KeyCodeCombination;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API响应结果的标准状态码枚举
 * 每个枚举常量代表一个HTTP状态码及其对应的描述信息
 */
@Getter
@AllArgsConstructor
/*
 * @Description: 枚举类
 * @Author: 落一.
 * @Date: 2025/5/19 19:04
 */
public enum ResultCode {

    /** 200: 请求成功 */
    SUCCESS(200, "操作成功"),
    
    /** 400: 客户端请求参数错误 */
    BAD_REQUEST(400, "参数错误"),
    
    /** 401: 未授权/认证失败 */
    UNAUTHORIZED(401, "未授权"),
    
    /** 403: 无权限访问 */
    FORBIDDEN(403, "禁止访问"),
    
    /** 404: 请求的资源不存在 */
    NOT_FOUND(404, "资源不存在"),
    
    /** 500: 服务器内部错误 */
    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    
    /** 503: 服务不可用 */
    SERVICE_UNAVAILABLE(503, "服务不可用");

    /** 状态码 */
    private final Integer code;
    
    /** 状态描述信息 */
    private final String message;
}
