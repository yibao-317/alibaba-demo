package com.yibao.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "order_form")
public class OrderForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 订单修改时间
     */
    @JsonProperty("update_time")
    private Date updateTime;

    /**
     * 订单是否生效：0不生效 1生效
     */
    private Integer flag;


}
