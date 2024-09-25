package com.pacemaker.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {
    private static final long serialVersionUID = -2106998647160940385L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;

}
