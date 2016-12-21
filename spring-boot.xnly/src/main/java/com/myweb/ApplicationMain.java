package com.myweb;

import com.framework.boot.servlet3.WebInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by BHWL on 2016-12-21.
 */
@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class ApplicationMain {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "login";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebInitializer.class, args);
    }
}
