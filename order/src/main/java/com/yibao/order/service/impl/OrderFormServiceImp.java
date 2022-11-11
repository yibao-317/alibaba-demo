package com.yibao.order.service.impl;

import com.yibao.order.entity.OrderForm;
import com.yibao.order.mapper.OrderFormMapper;
import com.yibao.order.service.OrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yibao
 * @create 2022 -11 -11
 * @desc
 */
@Service
public class OrderFormServiceImp implements OrderFormService {

    @Resource
    private OrderFormMapper orderMapper;

    @Override
    public OrderForm findById(Integer id) throws Exception {
        return orderMapper.selectById(id);
    }
}
