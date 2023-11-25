package com.mo.config;

import com.mo.log.event.SysLogListener;
import com.mo.service.LogService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mo on 2023/11/25
 * 日志配置类
 */
@Configuration
public class LogAutoConfiguration {

    //自动配置日志监听器组件
    @Bean
    @ConditionalOnMissingBean
    public SysLogListener sysLogListener(LogService logService) {
        return new SysLogListener(optLogDTO -> logService.saveLog(optLogDTO));
    }

}
