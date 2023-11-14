package com.company.a;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author Jerry
 * @date 2019/01/01 12:00
 */
@Slf4j
@EnableOpenApi
@EnableDubbo
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class AServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AServiceApplication.class, args);
    }
}

