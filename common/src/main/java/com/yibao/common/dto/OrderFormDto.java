package com.yibao.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yibao
 * @create 2022 -11 -14
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFormDto implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单用户id
     */
    private Integer uid;

    /**
     * 订单价格
     */
    private BigDecimal price;

    /**
     * 订单详情
     */
    private String detail;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单修改时间
     */
    private Date updateTime;

    /**
     * 订单是否生效：0不生效 1生效
     */
    private Integer flag;

    /**
     * 用户名
     */
    private String username;

}
