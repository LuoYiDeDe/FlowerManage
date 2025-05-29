package com.Luoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoginCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginCustomerApplication.class);
    }
}
