package com.mo;

import com.mo.auth.server.EnableAuthServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mo on 2023/11/26
 */
@SpringBootApplication
@EnableAuthServer
public class TestJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJwtDemoApplication.class, args);
    }
}
