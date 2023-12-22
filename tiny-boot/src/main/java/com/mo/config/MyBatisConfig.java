package com.mo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mo on 2023/12/21
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.mo.mbg.mapper")
public class MyBatisConfig {
}
