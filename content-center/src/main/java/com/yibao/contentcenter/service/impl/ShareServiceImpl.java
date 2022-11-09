package com.yibao.contentcenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yibao.common.dto.ShareDTO;
import com.yibao.common.dto.UserDTO;
import com.yibao.common.util.BaseResult;
import com.yibao.contentcenter.entity.Share;
import com.yibao.contentcenter.mapper.ShareMapper;
import com.yibao.contentcenter.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class ShareServiceImpl implements ShareService {

    @Resource
    private ShareMapper shareMapper;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public ShareDTO findById(Integer id) throws Exception {
        ShareDTO shareDTO = new ShareDTO();
        Share share = shareMapper.selectById(id);
        // 1.获取发布人 id
        Integer userId = share.getUserId();

        // 2.1 调用用户服务
        BaseResult result = restTemplate.getForObject(
                "http://user-center/users/{userId}",
                BaseResult.class,
                userId);
        // 2.2 数据转换
        String jsonObject= JSON.toJSONString(result.getData());
        UserDTO userDTO = JSONObject.parseObject(jsonObject, UserDTO.class);

        // 3.封装
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}
