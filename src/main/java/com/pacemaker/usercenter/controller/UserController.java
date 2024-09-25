package com.pacemaker.usercenter.controller;

import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.pacemaker.usercenter.exception.BusinessException;
import com.pacemaker.usercenter.model.User;
import com.pacemaker.usercenter.model.request.LoginRequest;
import com.pacemaker.usercenter.model.request.RegisterRequest;
import com.pacemaker.usercenter.utils.ErrorCode;
import com.pacemaker.usercenter.utils.HttpClientGet;
import com.pacemaker.usercenter.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pacemaker.usercenter.service.UserService;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.servlet.http.HttpServletRequest;

import static com.pacemaker.usercenter.utils.Constant.ROLE_NORMAL;
import static com.pacemaker.usercenter.utils.Constant.USER_LOGIN_STATUS;

/**
 * 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
@Tag(name = "控制层")
public class UserController {

    @Resource
    private UserService userService;
    private String url;

    /**
     * 添加
     *
     * @param user
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    @Operation(summary = "添加")
    @Parameters(value = {
            @Parameter(name = "id", description = "id"),
            @Parameter(name = "userAccount", description = "账号"),
            @Parameter(name = "phone", description = "电话号码"),
            @Parameter(name = "gender", description = "性别"),
            @Parameter(name = "userPassword", description = "密码"),
            @Parameter(name = "userStatus", description = "帐号状态（0-正常）"),
            @Parameter(name = "avatarUrl", description = "头像"),
            @Parameter(name = "email", description = "邮箱"),
            @Parameter(name = "userName", description = "用户昵称"),
            @Parameter(name = "updatetime", description = "更新时间"),
            @Parameter(name = "deletetime", description = "删除时间")})
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }


    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    @Operation(summary = "根据主键删除")
    @Parameters(value = {
            @Parameter(name = "id", description = "id", required = true)
    })
    public boolean remove(@PathVariable Serializable id) {
        return userService.removeById(id);
    }


    /**
     * 根据主键更新
     *
     * @param user
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    @Operation(summary = "根据主键更新")
    @Parameters(value = {
            @Parameter(name = "id", description = "id", required = true),
            @Parameter(name = "userAccount", description = "账号"),
            @Parameter(name = "phone", description = "电话号码"),
            @Parameter(name = "gender", description = "性别"),
            @Parameter(name = "userPassword", description = "密码"),
            @Parameter(name = "userStatus", description = "帐号状态（0-正常）"),
            @Parameter(name = "avatarUrl", description = "头像"),
            @Parameter(name = "email", description = "邮箱"),
            @Parameter(name = "userName", description = "用户昵称"),
            @Parameter(name = "updatetime", description = "更新时间"),
            @Parameter(name = "deletetime", description = "删除时间")})
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }



    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    @Parameters(value = {
            @Parameter(name = "pageNumber", description = "页码", required = true),
            @Parameter(name = "pageSize", description = "每页大小", required = true)
    })
    public Page<User> page(Page<User> page) {
        return userService.page(page);
    }


    @PostMapping("/httpGet")
    public String httpGet(){
        url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        String httpResponse = HttpClientGet.httpGet(url);
        return httpResponse;
    }

    /**
     * 注册
     * @Auther pacemaker
     */
    @PostMapping("/register")
    public Result userRegister(@RequestBody RegisterRequest registerRequest){
        if(registerRequest == null)
            throw new BusinessException(ErrorCode.PAEAMS_ERROR,"用户输入为空");
        String userAccount = registerRequest.getUserAccount();
        String userPassword = registerRequest.getUserPassword();
        String checkPassword = registerRequest.getCheckPassword();
        if(!StrUtil.isAllNotBlank(userAccount,userPassword,checkPassword))
        {
            throw new BusinessException(ErrorCode.PAEAMS_ERROR,"用户输入为空");
        }
        return userService.userRegister(userPassword,userPassword,checkPassword);
    }
    /**
     * 登录
     * @Auther pacemaker
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody LoginRequest loginRequest, HttpServletRequest request){
        if(loginRequest == null)
            return Result.error(ErrorCode.PAEAMS_ERROR);
        String userAccount = loginRequest.getUserAccount();
        String userPassword = loginRequest.getUserPassword();

        if(!StrUtil.isAllNotBlank(userAccount,userPassword))
        {
            return Result.error(ErrorCode.PAEAMS_ERROR);
        }
        return userService.userLogin(userPassword,userPassword,request);
    }
    @PostMapping("/loginout")
    public Result userLoginout(HttpServletRequest request){
        return userService.userLoginout(request);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello,World";
    }

}