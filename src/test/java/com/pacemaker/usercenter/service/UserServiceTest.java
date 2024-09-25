package com.pacemaker.usercenter.service;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mybatisflex.core.query.QueryWrapper;
import com.pacemaker.usercenter.model.MyIDCardInfo;
import com.pacemaker.usercenter.model.TargetIDCardInfo;
import com.pacemaker.usercenter.model.User;
import com.pacemaker.usercenter.utils.Result;
import lombok.SneakyThrows;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

import static com.pacemaker.usercenter.model.table.UserTableDef.USER;
import static com.pacemaker.usercenter.utils.Constant.SALT;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setPhone("123");
        user.setAvatarUrl("https://ts1.cn.mm.bing.net/th/id/R-C.5c4a9d2421824c6335e18f616b51980f?rik=yUzUzyy%2fTFO59Q&riu=http%3a%2f%2fvignette4.wikia.nocookie.net%2ffree-anime%2fimages%2ff%2ff1%2fGou_1.jpg%2frevision%2flatest%3fcb%3d20130824175837&ehk=vzpkQ4jMOjFB56tVhSd8xWqjG2koxRtojdTbghTbYFE%3d&risl=&pid=ImgRaw&r=0");
        user.setEmail("13");
        user.setUserName("13");
        user.setUserAccount("root");
        user.setUserPassword("123456");
        boolean result = userService.save(user);
        Assertions.assertTrue(result);//断言

    }

    @Test
    public void testPattern() {
        String validPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(".,%hhh j");
        if (matcher.find())
            System.out.println(1);

    }


    @Test
    public void testDigestPassword() {
        String digestedPassword = DigestUtils.md5DigestAsHex((SALT + "huhuhu123").getBytes());
        System.out.println(digestedPassword);

    }

    @Test
    void userRegister() {
        Result result = userService.userRegister("123asd fg", "1234561212", "1234561212");
        Assertions.assertEquals(1, result);
    }

    @Test
    void userLogicalDeleted() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.where(USER.ID.eq(2));

        User user = userService.getOne(wrapper);
        System.out.println(user);
    }
    @Test
    void testUserLogin() {
        Result result = userService.userLogin("huhuhu11", "huhuhu11", null);
        System.out.println(result);
    }

    @Test
    @SneakyThrows
    void test() {
        String macAddress = "10:a5:62:14:0c:a2";
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(macAddress.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        System.out.println("终端代码："+hexString.toString());



    }

    @Test
    void test1() {
        MyIDCardInfo myIDCardInfo = new MyIDCardInfo();
        myIDCardInfo.setName("������");
        myIDCardInfo.setIssue("��");
        myIDCardInfo.setNation("����");
        myIDCardInfo.setEffectData("1990.01.01");
        myIDCardInfo.setAddress("������");
        myIDCardInfo.setIdno("123456789012345678");
        myIDCardInfo.setAreaCode("111");
        TargetIDCardInfo targetIDCardInfo = new TargetIDCardInfo();

        BeanUtils.copyProperties(myIDCardInfo,targetIDCardInfo);
        System.out.println(myIDCardInfo);
        System.out.println(targetIDCardInfo);
    }

}