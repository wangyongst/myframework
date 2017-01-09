package com.myweb;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by BHWL on 2016-12-28.
 */
public class Video {

    public static int time = 0;

    public static void main(String[] args) {
        //String url = "http://api.47ks.com/webcloud/?v=";
        String url = "http://000o.cc/jx/ty.php?url=";
        url = url + "http://www.iqiyi.com/v_19rra0dh6c.html?fc=8b62d5327a54411b#vfrm=19-9-0-1";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = response.getBody();
        System.out.println(body);
    }
}
