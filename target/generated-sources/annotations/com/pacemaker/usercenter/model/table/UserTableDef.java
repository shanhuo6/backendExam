package com.pacemaker.usercenter.model.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserTableDef extends TableDef {

    /**
     * 实体类。

 @author mybatis-flex-helper automatic generation
 @since 1.0
     */
    public static final UserTableDef USER = new UserTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 邮箱
     */
    public final QueryColumn EMAIL = new QueryColumn(this, "email");

    /**
     * 电话号码
     */
    public final QueryColumn PHONE = new QueryColumn(this, "phone");

    /**
     * 性别
     */
    public final QueryColumn GENDER = new QueryColumn(this, "gender");

    /**
     * 用户昵称
     */
    public final QueryColumn USER_NAME = new QueryColumn(this, "user_Name");

    /**
     * 头像
     */
    public final QueryColumn AVATAR_URL = new QueryColumn(this, "avatar_url");

    /**
     * 帐号状态（0-正常,1-被逻辑删除）
     */
    public final QueryColumn USER_STATUS = new QueryColumn(this, "user_status");

    /**
     * 账号
     */
    public final QueryColumn USER_ACCOUNT = new QueryColumn(this, "user_account");

    /**
     * 密码
     */
    public final QueryColumn USER_PASSWORD = new QueryColumn(this, "user_password");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, EMAIL, PHONE, GENDER, USER_NAME, AVATAR_URL, USER_ACCOUNT, USER_PASSWORD};

    public UserTableDef() {
        super("", "user");
    }

    private UserTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public UserTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new UserTableDef("", "user", alias));
    }

}
