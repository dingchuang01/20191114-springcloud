package com.aaa.dc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.aaa.dc.springcloud.service")
public class ApplicationRun6083{

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6083.class,args);
    }
}
