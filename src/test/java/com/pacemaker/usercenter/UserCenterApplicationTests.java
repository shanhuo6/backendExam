package com.pacemaker.usercenter;

import com.pacemaker.usercenter.model.User;
import com.pacemaker.usercenter.service.UserService;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.pacemaker.usercenter.model.table.UserTableDef.USER;


@SpringBootTest
class UserCenterApplicationTests {



    @Test
    void contextLoads() {
/*        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();//Spring Container
        Object userService = context.getBean("userService");//Bean

        for (Field field : userService.getClass().getFields()) {
            if(field.isAnnotationPresent(Autowired.class)){
                //进行依赖注入
            }
        }

        for (Method method : userService.getClass().getMethods()) {
            method.isAnnotationPresent(PostConstruct.class)
            {
                method.invoke("给对象传参");
            }
        }
        if(User instanceof InitializingBean)
        {//判断这个属性对象是否实现了IniizingBean接口，若实现了就执行afterPropertiesSet()
            ((InitializingBean)User).afterPropertiesSet();
        }*/
    }


}
