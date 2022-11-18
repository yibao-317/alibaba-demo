package com.yibao.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yibao
 * @create 2022 -11 -17
 * @desc
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @GetMapping("/test")
    public void test() {
        log.info("-------- consumer is ok -------");
    }

}
