package com.yibao.user.service.impl;


import com.yibao.common.dto.user.UserVO;
import com.yibao.user.entity.User;
import com.yibao.user.mapper.UserMapper;
import com.yibao.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO findById(Integer id) throws Exception {
        User user = userMapper.selectById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;

    }
}
