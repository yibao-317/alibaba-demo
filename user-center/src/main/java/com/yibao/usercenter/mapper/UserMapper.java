package com.yibao.usercenter.mapper;

import com.yibao.usercenter.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yibao
 * @create 2022 -11 -04
 * @desc 用户 Mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}