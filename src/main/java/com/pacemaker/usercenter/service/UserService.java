package com.pacemaker.usercenter.service;



import com.mybatisflex.core.service.IService;
import com.pacemaker.usercenter.model.User;
import com.pacemaker.usercenter.utils.Result;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
public interface  UserService extends IService<User> {
    /**
     *
     * @param userAccount 账号
     * @param userPassword 密码
     * @param checkPassword 校验密码
     * @return
     */
    Result userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     *
     * @param userAccount 账号
     * @param userPassword 密码
     * @return 返回脱敏对象
     */
    Result userLogin(String userAccount, String userPassword, HttpServletRequest request);

    Result userLoginout(HttpServletRequest request);

}