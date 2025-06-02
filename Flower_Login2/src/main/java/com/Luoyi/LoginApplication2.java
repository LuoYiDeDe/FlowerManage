package com.Luoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LoginApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication2.class);
    }
}
