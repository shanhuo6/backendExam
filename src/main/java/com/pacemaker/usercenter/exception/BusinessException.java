package com.pacemaker.usercenter.exception;

import com.pacemaker.usercenter.utils.ErrorCode;

public class BusinessException extends RuntimeException{
    private int code;
    private String description;


    public BusinessException(String message,int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }
    public BusinessException(ErrorCode errorCode,String detailDescription) {
        super();
        this.code = errorCode.getCode();
        this.description = detailDescription;
    }

    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "BUsinessException{code = " + code + ", description = " + description + "}";
    }
}
