package com.yibao.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yibao.sentinel.service.SentinelServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yibao
 * @create 2022 -11 -17
 * @desc
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    @Resource
    private SentinelServiceImp sentinelServiceImp;

    @GetMapping("/test1")
    public String test1() {
        return "1 is ok" ;
    }

    @GetMapping("/test2")
    public String test2() {
        // 调用公共资源
        sentinelServiceImp.common();
        return " --- 2 is ok";
    }

    @GetMapping("/test3/{id}")
    @SentinelResource("/test3/{id}")
    public String test3(@PathVariable Integer id) {
        return "3 is ok -- id: " + id;
    }

    @GetMapping("/test4")
    public String test4() {
        // 调用公共资源
        sentinelServiceImp.common();
        return " --- 4 is ok";
    }

}
