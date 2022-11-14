package com.yibao.user.service;

import com.yibao.common.dto.user.UserVO;

public interface UserService {

    /**
     * 方法：根据 id 查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    UserVO findById(Integer id) throws Exception;
}
