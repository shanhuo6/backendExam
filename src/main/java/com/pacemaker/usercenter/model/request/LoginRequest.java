package com.pacemaker.usercenter.model.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -2351930097033892116L;
    private String userAccount;
    private String userPassword;


}
