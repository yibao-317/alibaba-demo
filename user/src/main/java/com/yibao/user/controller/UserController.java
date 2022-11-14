package com.yibao.user.controller;


import com.yibao.common.dto.user.UserVO;
import com.yibao.common.util.BaseResult;
import com.yibao.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yibao
 * @create 2022 -11 -04
 * @desc 用户
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/findById/{id}")
    public BaseResult findById(@PathVariable Integer id) {
        try {
            UserVO userVO = userService.findById(id);
            return BaseResult.success(userVO);
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }

    }

}

