package com.yibao.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yibao
 * @create 2022 -11 -07
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShareDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 发布人id
     */
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
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
    private String downloadUrl;

    /**
     * 下载数
     */
    private Integer buyCount;


    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;

    /**
     * 微信昵称
     */
    private String wxNickname;
}
