package com.myweb;

import com.framework.boot.servlet3.WebInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by BHWL on 2016-12-21.
 */
@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        //启动Spring Boot项目的唯一入口
        SpringApplication.run(WebInitializer.class, args);
    }
}
