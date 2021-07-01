package com.xiaofang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConfigNacosClient3377Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConfigNacosClient3377Application.class, args);
    }
}
