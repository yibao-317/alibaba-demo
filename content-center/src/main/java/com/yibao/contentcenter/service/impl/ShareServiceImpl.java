package com.yibao.contentcenter.service.impl;

import com.yibao.common.dto.ShareDTO;
import com.yibao.common.dto.UserDTO;
import com.yibao.contentcenter.entity.Share;
import com.yibao.contentcenter.mapper.ShareMapper;
import com.yibao.contentcenter.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ShareServiceImpl implements ShareService {

    @Resource
    private ShareMapper shareMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Override
    public ShareDTO findById(Integer id) throws Exception {
        ShareDTO shareDTO = new ShareDTO();
        Share share = shareMapper.selectById(id);
        // 1.获取发布人 id
        Integer userId = share.getUserId();

        // 2.1获取用户中心所有示例（nacos）
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        // 2.2获取服务地址
        String targetURL = instances.stream()
                // 数据转换
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .findFirst()
                .orElseThrow(() -> new RuntimeException("当前没有调用实例！"));
        // 2.3 调用用户服务
        UserDTO userDTO = restTemplate.getForObject(targetURL, UserDTO.class, userId);

        // 3.封装
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}
