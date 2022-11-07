package com.yibao.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yibao
 * @create 2022 -11 -07
 * @desc 统一返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Integer OK = 200;
    private static final Integer ERROR = 500;


    // 状态码
    private Integer code;
    // 信息
    private String message;
    // 返回数据
    private T data;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 方法：执行成功，返回默认信息
     * @return
     */
    public static BaseResult success() {
        return new BaseResult(OK, "success");
    }

    /**
     * 方法：执行成功，返回自定义信息
     * @param message
     * @return
     */
    public static BaseResult success(String message) {
        return new BaseResult(OK, message);
    }

    /**
     * 方法：执行成功，返回默认信息，数据
     * @param data
     * @return
     */
    public static <T> BaseResult success(T data) {
        return new BaseResult(OK, "success", data);
    }

    /**
     * 方法：执行成功，返回自定义信息，数据
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResult success(String message, T data) {
        return new BaseResult(OK, message, data);
    }

    /**
     * 方法：执行失败，返回默认信息
     * @return
     */
    public static BaseResult error() {
        return new BaseResult(ERROR, "error");
    }

    /**
     * 方法：执行失败，返回自定义信息
     * @param message
     * @return
     */
    public static BaseResult error(String message) {
        return new BaseResult(ERROR, message);
    }

}
