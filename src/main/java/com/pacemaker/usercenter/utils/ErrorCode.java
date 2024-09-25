package com.pacemaker.usercenter.utils;

import lombok.Data;

public enum ErrorCode {
    PAEAMS_ERROR(40001,"参数为空"),
    NOT_LOGIN(40100,"用户未登录"),
    SYSTEM_ERROR(50000,"系统内部问题"),
    NO_AUTH(40101,"用户没有权限");
    private int code;
    private String description;

    ErrorCode() {
    }

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }


    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }


    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }



}
