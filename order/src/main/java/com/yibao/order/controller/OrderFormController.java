package com.yibao.order.controller;


import com.yibao.common.dto.OrderFormDto;
import com.yibao.common.util.BaseResult;
import com.yibao.common.service.OrderFormService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单业务
 * @author yibao
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/order")
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


}

