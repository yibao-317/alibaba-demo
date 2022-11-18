package com.yibao.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author yibao
 * @create 2022 -11 -18
 * @desc
 */
@Service
public class SentinelServiceImp {

    @SentinelResource("common")
    public void common() {
        System.out.println("------ 测试公共资源调用（链路）------");
    }

}
