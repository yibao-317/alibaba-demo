package com.yibao.usercenter.service;

import com.yibao.common.dto.UserDTO;

public interface UserService {

    /**
     * 方法：根据用户 id 查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserDTO findById(Integer id) throws Exception;

}
