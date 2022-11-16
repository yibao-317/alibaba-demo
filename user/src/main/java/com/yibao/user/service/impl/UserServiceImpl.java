package com.yibao.user.service.impl;


import com.yibao.common.dto.UserDto;
import com.yibao.common.service.UserService;
import com.yibao.user.entity.User;
import com.yibao.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

@DubboService
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto findById(Integer id) throws Exception {
        log.info("------ user 被调用 ------");
        User user = userMapper.selectById(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
