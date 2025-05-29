package com.Luoyi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;    // 状态码
    private String message;  // 返回消息
    private T data;          // 返回数据
    private long timestamp = System.currentTimeMillis(); // 时间戳

    public Result(Integer code, String message, T data, long timestamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(T data) {
        this.data = data;
    }

    // 成功返回（无数据）
    public static <T> Result<T> success() {
        return success(null);
    }

    // 成功返回（带数据）
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(),
                          ResultCode.SUCCESS.getMessage(),
                          data);
    }

    // 失败返回
    public static <T> Result<T> fail(String message) {
        return fail(ResultCode.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    // 失败返回（自定义状态码和消息）
    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    // 失败返回（使用预定义错误码）
    public static <T> Result<T> fail(ResultCode resultCode) {
        return fail(resultCode.getCode(), resultCode.getMessage());
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

