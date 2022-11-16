package com.yibao.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yibao
 * @create 2022 -11 -14
 * @desc
 */
@Data
public class UserDto implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 是否删除：0用户名存在 1用户已删除
     */
    private Integer flag;


}
