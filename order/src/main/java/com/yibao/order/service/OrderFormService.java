package com.yibao.order.service;

import com.yibao.order.entity.OrderForm;

/**
 * @author yibao
 * @create 2022 -11 -11
 * @desc
 */
public interface OrderFormService {
    /**
     * 方法：根据 id 查询订单信息
     * @param id
     * @return
     * @throws Exception
     */
    OrderForm findById(Integer id) throws Exception;
}
