package com.yibao.usercenter.service.impl;


import com.yibao.common.dto.UserDTO;
import com.yibao.usercenter.entity.User;
import com.yibao.usercenter.mapper.UserMapper;
import com.yibao.usercenter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO findById(Integer id) throws Exception {
        UserDTO userDTO = new UserDTO();
        User user = userMapper.selectById(id);
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
