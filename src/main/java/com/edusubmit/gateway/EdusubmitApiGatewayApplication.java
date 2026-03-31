package com.edusubmit.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EdusubmitApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdusubmitApiGatewayApplication.class, args);
    }
}
