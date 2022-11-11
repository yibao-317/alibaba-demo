package com.yibao.dbmanager.controller;

import com.yibao.common.util.AutoCodeGenerator;
import com.yibao.common.util.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yibao
 * @create 2022 -11 -11
 * @desc 自动生成实体类（可扩展配置）
 */
@RestController
@RequestMapping("/autoCode")
public class AutoCodeController {

    @GetMapping("/autoCode")
    public BaseResult autoCode() {
        try {
            AutoCodeGenerator.autoCode();
            return BaseResult.success();
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }


}
