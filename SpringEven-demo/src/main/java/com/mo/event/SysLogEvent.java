package com.mo.event;

import com.mo.dto.OptLogDTO;
import org.springframework.context.ApplicationEvent;

/**
 * Created by mo on 2023/11/24
 * 定义系统日志事件
 */
public class SysLogEvent  extends ApplicationEvent {
    public SysLogEvent(OptLogDTO optLogDTO) {
        super(optLogDTO);
    }
}
