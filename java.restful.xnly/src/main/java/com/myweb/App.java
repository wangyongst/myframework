package com.myweb;

import com.myweb.util.Result;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String url = "http://localhost:8080/web/framework/get/tableinfos/user/false.do";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }
}
