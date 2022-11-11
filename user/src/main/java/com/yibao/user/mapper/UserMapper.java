package com.yibao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yibao.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yibao
 * @create 2022 -11 -11
 * @desc
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
