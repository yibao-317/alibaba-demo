package com.yibao.order.service.impl;

import com.yibao.common.dto.OrderFormDto;
import com.yibao.common.dto.UserDto;
import com.yibao.common.service.OrderFormService;
import com.yibao.common.service.UserService;
import com.yibao.order.entity.OrderForm;
import com.yibao.order.mapper.OrderFormMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @author yibao
 * @create 2022 -11 -11
 * @desc
 */
@DubboService
public class OrderFormServiceImp implements OrderFormService {

    @Resource
    private OrderFormMapper orderMapper;

    @DubboReference
    private UserService userService;

    @Override
    public OrderFormDto findById(Integer id) throws Exception {
        // 1.查询订单信息
        OrderForm orderForm = orderMapper.selectById(id);
        // 2.获取用户 id
        Integer uid = orderForm.getUid();
        // 3.远程调用
        UserDto userDto = userService.findById(uid);
        // 4.封装参数
        OrderFormDto orderFormDto = new OrderFormDto();
        orderFormDto.setUsername(userDto.getUname());
        BeanUtils.copyProperties(orderForm, orderFormDto);
        // 5.返回
        return orderFormDto;
    }


}
