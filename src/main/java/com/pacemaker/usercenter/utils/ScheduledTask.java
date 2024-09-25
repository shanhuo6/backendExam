package com.pacemaker.usercenter.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Slf4j
public class ScheduledTask {
/*    //每三秒执行一次
    @Scheduled(cron = "0/3 * * * * ? ")
    public void executeTask(){
        log.info("定时任务执行"+ new Date());

    }*/
    //每分钟查询一次
    @Scheduled(cron = "0 * * * * ? ")
    public void TimeoutOrderTask(){
        //查询待付款且时间超时的订单
        //修改订单状态


    }
}
