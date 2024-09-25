package com.pacemaker.usercenter.service.iml;

import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.pacemaker.usercenter.mapper.UserMapper;
import com.pacemaker.usercenter.model.User;
import com.pacemaker.usercenter.service.UserService;
import com.pacemaker.usercenter.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.pacemaker.usercenter.model.table.UserTableDef.USER;
import static com.pacemaker.usercenter.utils.Constant.SALT;
import static com.pacemaker.usercenter.utils.Constant.USER_LOGIN_STATUS;

@Component
@Slf4j
public class UserServiceIml extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     *
     * @userRegister用户注册
     */
    @Override
    public Result userRegister(String userAccount, String userPassword, String checkPassword) {
        //1,判空
        if(StrUtil.isBlank(userAccount) || StrUtil.isBlank(userPassword ) ||
        StrUtil.isBlank(checkPassword))
            return Result.error("不能为空");
        //2,判断长度
        if(userAccount.length() < 4 || userPassword.length() < 8 )
            return Result.error("长度不够");
        //3.账号不能包含特殊字符
        String validPattern = "\\pP|\\pS|\\s+";//包含所有标点字符、符号字符或一个及以上的空白字符（不包括英文字符）
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find())
            return Result.error("包含特殊字符");
        //4,校验密码和校验密码是否相同
        if(!userPassword.equals(checkPassword))
            return Result.error("密码和校验密码不相同");
        //5,校验账号是否重复,从数据库中查询
        QueryWrapper accountQuery = new QueryWrapper();
        accountQuery.where(USER.USER_ACCOUNT.eq(userAccount));
        long count = this.count(accountQuery);
        if(count > 0)
            return Result.error("账号重复");
        //6,密码加密

        String digestedPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        log.info(digestedPassword + "11111111111111111");
        //7,插入数据库
        User user = new User();
        user.setUserPassword(digestedPassword);
        user.setUserAccount(userAccount);
        boolean saveResult = this.save(user);
        if(!saveResult)
            return Result.error("插入失败");
        return Result.success("ok"+ user.getId());
    }

    @Override
    public Result userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //1,初步校验，不用每次都查询数据库
        //1,判空
        if(StrUtil.isBlank(userAccount) || StrUtil.isBlank(userPassword))
            return Result.error("不能为空");
        //2,判断长度
        if(userAccount.length() < 4 || userPassword.length() < 8 )
            return Result.error("长度不够");
        //3.账号不能包含特殊字符
        String validPattern = "\\pP|\\pS|\\s+";//包含所有标点字符、符号字符或一个及以上的空白字符（不包括英文字符）
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find())
            return Result.error("包含特殊字符");
        //2,库中是否存在
        QueryWrapper loginQuery = new QueryWrapper();
        String digestedPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        log.info(digestedPassword + "22222222222222222");
        loginQuery.where(USER.USER_ACCOUNT.eq(userAccount))
                .and(USER.USER_PASSWORD.eq(digestedPassword));
        User one = this.getOne(loginQuery);
        if(one == null)
        {
            return Result.error("账号密码错误或者用户未注册");
        }
        //3，用户脱敏（可以新建DTO对象返回）
        User safetyUser = new User();
        safetyUser.setId(one.getId());
        safetyUser.setUserAccount(one.getUserAccount());
        safetyUser.setPhone(one.getPhone());
        safetyUser.setGender(one.getGender());
        safetyUser.setAvatarUrl(one.getAvatarUrl());
        safetyUser.setEmail(one.getEmail());
        safetyUser.setUserName(one.getUserName());
        //4，记录登录态
        request.getSession().setAttribute(USER_LOGIN_STATUS,safetyUser);
/*        log.info((String) request.getSession().getAttribute(USER_LOGIN_STATUS));*/
        return Result.success(safetyUser);
    }

    @Override
    public Result userLoginout(HttpServletRequest request) {
        request.getSession().removeAttribute(USER_LOGIN_STATUS);
        return Result.success();
    }
}
