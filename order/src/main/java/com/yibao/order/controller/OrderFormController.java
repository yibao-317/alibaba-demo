package com.yibao.order.controller;


import com.yibao.common.dto.OrderFormDto;
import com.yibao.common.service.OrderFormService;
import com.yibao.common.util.BaseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单业务
 * @author yibao
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/order")
//@EnableScheduling   // 启动 xxl-job
public class OrderFormController {

    @Resource
    private OrderFormService orderFormService;

    @GetMapping("/findById/{id}")
    public BaseResult findById(@PathVariable Integer id) {
        try {
            OrderFormDto order = orderFormService.findById(id);
            return BaseResult.success(order);
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }

    /**
     * 方法：测试 xxl-job
     */
    @GetMapping("/testXxlJob")
//    @Scheduled(cron = "*/5 * * * * ?")
    public void testXxlJob() {
        System.out.println("xxl-job is executing...");
    }


    /**
     * 方法：测试 Gateway 过滤器是否生效
     */
    @GetMapping("/gatewaySingleFilterTest")
    public void gatewaySingleFilterTest(@RequestHeader(value = "Truth",required = false) String truth) {
        System.out.println(truth);
    }



}

