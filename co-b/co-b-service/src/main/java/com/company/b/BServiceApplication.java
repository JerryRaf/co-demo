package com.company.b;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jerry
 * @date 2019/01/01 12:00
 */
@EnableDubbo
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class BServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BServiceApplication.class, args);
    }
}

