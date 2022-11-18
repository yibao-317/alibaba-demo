package com.yibao.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yibao
 * @create 2022 -11 -17
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SleuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
    }
}
