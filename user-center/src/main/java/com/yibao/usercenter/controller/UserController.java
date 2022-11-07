package com.yibao.usercenter.controller;


import com.yibao.common.dto.UserDTO;
import com.yibao.common.util.BaseResult;
import com.yibao.usercenter.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public BaseResult findById(@PathVariable Integer id) {
        try {
            UserDTO userDTO = userService.findById(id);
            return BaseResult.success(userDTO);
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }
}

