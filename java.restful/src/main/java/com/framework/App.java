package com.framework;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String url = "https://eerg.talentlms.com/api/v1/gotocourse/user_id:2,course_id:125,course_completed_redirect:google.com,logout_redirect:google.com";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> requestEntity = new HttpEntity();
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = response.getBody();
        JSONObject json = new JSONObject(body);
        System.out.println(json.getString("goto_url"));
        String result = restTemplate.getForObject(json.getString("goto_url"), String.class);
        System.out.println(result);
    }
}
