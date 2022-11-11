package com.yibao.user.service.impl;


import com.yibao.user.entity.User;
import com.yibao.user.mapper.UserMapper;
import com.yibao.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) throws Exception {
        return userMapper.selectById(id);
    }
}
