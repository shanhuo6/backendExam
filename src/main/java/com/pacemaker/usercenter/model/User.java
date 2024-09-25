package com.pacemaker.usercenter.model;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Data
@Table(value = "user")
public class User {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 账号
     */
    @Column(value = "user_account")
    private String userAccount;

    /**
     * 电话号码
     */
    @Column(value = "phone")
    private String phone;

    /**
     * 性别
     */
    @Column(value = "gender")
    private Integer gender;
    /**
     * 密码
     */
    @Column(value = "user_password")
    private String userPassword;

    /**
     * 帐号状态（0-正常,1-被逻辑删除）
     */
    @Column(isLogicDelete = true, value = "user_status")
    private Integer userStatus;

    /**
     * 头像
     */
    @Column(value = "avatar_url")
    private String avatarUrl;

    /**
     * 邮箱
     */
    @Column(value = "email")
    private String email;

    /**
     * 用户昵称
     */
    @Column(value = "user_Name")
    private String userName;


}