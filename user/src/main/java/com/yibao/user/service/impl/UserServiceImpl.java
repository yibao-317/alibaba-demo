package com.yibao.user.service.impl;


import com.yibao.common.dto.UserDto;
import com.yibao.user.entity.User;
import com.yibao.user.mapper.UserMapper;
import com.yibao.common.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto findById(Integer id) throws Exception {
        User user = userMapper.selectById(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;

    }
}
