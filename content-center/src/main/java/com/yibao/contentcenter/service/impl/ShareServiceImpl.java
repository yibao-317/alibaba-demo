package com.yibao.contentcenter.service.impl;

import com.yibao.common.dto.ShareDTO;
import com.yibao.common.dto.UserDTO;
import com.yibao.contentcenter.entity.Share;
import com.yibao.contentcenter.mapper.ShareMapper;
import com.yibao.contentcenter.service.ShareService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class ShareServiceImpl implements ShareService {

    @Resource
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ShareDTO findById(Integer id) throws Exception {
        ShareDTO shareDTO = new ShareDTO();
        Share share = shareMapper.selectById(id);
        // 获取发布人 id
        Integer userId = share.getUserId();
        // http 远程调用
        UserDTO userDTO = restTemplate.getForObject(
                "http://localhost:9001/users/{id}",
                UserDTO.class,
                userId);

        // 封装
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}
