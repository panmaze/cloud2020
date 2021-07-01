package com.xiaofang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaProviderPayment9002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment9002Application.class, args);
    }
}
