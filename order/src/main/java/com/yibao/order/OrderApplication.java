package com.yibao.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yibao
 * @create 2022 -11 -10
 * @desc
 */
@SpringBootApplication
@MapperScan(value = "com.yibao.order.mapper")
@EnableDiscoveryClient
@EnableDubbo
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
