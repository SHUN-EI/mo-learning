package com.mo.controller;

import com.mo.dto.OptLogDTO;
import com.mo.event.SysLogEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mo on 2023/11/24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/getUser")
    public String getUser() {
        //构造操作日志信息
        OptLogDTO optLogDTO = OptLogDTO.builder().requestIp("127.0.0.1")
                .userName("admin")
                .type("opt")
                .description("查询用户信息").build();

        //构造事件对象
        SysLogEvent event = new SysLogEvent(optLogDTO);

        //发布事件
        applicationContext.publishEvent(event);

        long id = Thread.currentThread().getId();
        System.out.println("发布事件,线程id：" + id);
        return "OK";

    }
}
