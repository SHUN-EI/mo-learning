package com.mo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by mo on 2023/11/24
 */
@SpringBootApplication
@EnableAsync
public class SpringEvenDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEvenDemoApplication.class, args);
    }
}
