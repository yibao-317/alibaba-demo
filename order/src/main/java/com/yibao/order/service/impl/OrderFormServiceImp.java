package com.yibao.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yibao.common.dto.OrderFormDto;
import com.yibao.common.dto.UserDto;
import com.yibao.common.util.BaseResult;
import com.yibao.order.entity.OrderForm;
import com.yibao.order.mapper.OrderFormMapper;
import com.yibao.common.service.OrderFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Resource
    private RestTemplate restTemplate;

    @Override
    public OrderFormDto findById(Integer id) throws Exception {
        // 1.查询订单信息
        OrderForm orderForm = orderMapper.selectById(id);
        // 2.获取用户 id
        Integer uid = orderForm.getUid();
        // 3.远程调用，获取用户名
        BaseResult<UserDto> baseResult = restTemplate.getForObject("http://localhost:9001/user/findById/{uid}", BaseResult.class, uid);
        // 3.1 数据转换
        String jsonObject= JSON.toJSONString(baseResult.getData());
        UserDto userDto = JSONObject.parseObject(jsonObject, UserDto.class);
        // 4.封装参数
        OrderFormDto orderFormDto = new OrderFormDto();
        BeanUtils.copyProperties(orderForm, orderFormDto);
        orderFormDto.setUsername(userDto.getUname());
        // 5.返回
        return orderFormDto;
    }
}
