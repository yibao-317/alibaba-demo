package com.yibao.contentcenter.entity;

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
 * @desc 分享表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Share implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布人id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 标题
     */
    private String title;

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
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    /**
     * 价格（需要的积分）
     */
    private Integer price;

    /**
     * 下载地址
     */
    @JsonProperty("download_url")
    private String downloadUrl;

    /**
     * 下载数 
     */
    @JsonProperty("buy_count")
    private Integer buyCount;


    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    @JsonProperty("audit_status")
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;


}
