package com.yibao.user.service;

import com.yibao.user.entity.User;

public interface UserService {

    /**
     * 方法：根据 id 查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    User findById(Integer id) throws Exception;
}
