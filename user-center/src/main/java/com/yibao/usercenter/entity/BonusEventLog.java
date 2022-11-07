package com.yibao.usercenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yibao
 * @create 2022 -11 -04
 * @desc 积分变更记录表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BonusEventLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user.id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 积分操作值
     */
    private Integer value;

    /**
     * 发生的事件
     */
    private String event;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 描述
     */
    private String description;


}
