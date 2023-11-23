package com.mo;

import com.mo.config.EnableFormValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mo on 2023/11/23
 */
@SpringBootApplication
@EnableFormValidator
public class HibernateValidatorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateValidatorDemoApplication.class, args);
    }
}
