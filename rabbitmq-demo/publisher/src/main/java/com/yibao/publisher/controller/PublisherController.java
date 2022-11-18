package com.yibao.publisher.controller;

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
@RequestMapping("/publisher")
@Slf4j
public class PublisherController {

    @GetMapping("/test")
    public void test() {
        log.info("-------- publisher is ok -----------");
    }



}
