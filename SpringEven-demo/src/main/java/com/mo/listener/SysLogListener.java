package com.mo.listener;

import com.mo.dto.OptLogDTO;
import com.mo.event.SysLogEvent;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by mo on 2023/11/24
 */
@Component
public class SysLogListener {

    @Async////异步处理
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent sysLogEvent) {

        OptLogDTO optLogDTO = (OptLogDTO) sysLogEvent.getSource();
        long id = Thread.currentThread().getId();
        System.out.println("监听到日志操作事件：" + optLogDTO + " 线程id：" + id);

    }
}
