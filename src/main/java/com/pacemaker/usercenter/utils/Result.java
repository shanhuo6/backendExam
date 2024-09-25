package com.pacemaker.usercenter.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -3726698536473703387L;
    private Integer code;
    private String msg;
    private T data;

    /*    public Result(Integer code, String msg, T data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }*/
    public Result(T data)
    {
        this(null,null,data);
    }



    //增删改 成功响应

    public static Result success() {
        return new Result(1, "success", null);
    }

    //查询 成功响应
    public static <T>Result<T> success(T data) {
        return new Result(1, "success", data);
    }

    //失败响应
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    public static Result error(ErrorCode errorCode) {
        return new Result(errorCode);
    }



}
