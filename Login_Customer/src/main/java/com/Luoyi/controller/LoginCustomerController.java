package com.Luoyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class LoginCustomerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/newlogin")
    public String getInfo(@RequestParam String username, @RequestParam String password){
        // 使用postForObject发送POST请求
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", username);
        requestBody.add("password", password);

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        return restTemplate.postForObject(
                "http://MyLoginService/login",
                requestBody,
                String.class
        );
    }

    @RequestMapping("/newadmin")
    public String admin(@RequestParam String username, @RequestParam String password){
        // 使用postForObject发送POST请求
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", username);
        requestBody.add("password", password);

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        return restTemplate.postForObject(
                "http://MyLoginService/adminlogin",
                requestBody,
                String.class
        );
    }
}
