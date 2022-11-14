package com.yibao.common.service;

import com.yibao.common.dto.UserDto;

public interface UserService {

    /**
     * 方法：根据 id 查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    UserDto findById(Integer id) throws Exception;
}
