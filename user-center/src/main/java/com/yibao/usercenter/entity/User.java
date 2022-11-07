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
 * @desc 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 微信id
     */
    @JsonProperty("wx_id")
    private String wxId;

    /**
     * 微信昵称
     */
    @JsonProperty("wx_nickname")
    private String wxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 头像地址
     */
    @JsonProperty("avatar_url")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonProperty("update_time")
    private Date updateTime;

    /**
     * 积分
     */
    private Integer bonus;


}
