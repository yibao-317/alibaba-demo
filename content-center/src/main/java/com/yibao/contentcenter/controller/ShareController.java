package com.yibao.contentcenter.controller;


import com.yibao.common.dto.ShareDTO;
import com.yibao.common.util.BaseResult;
import com.yibao.contentcenter.service.ShareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yibao
 * @create 2022 -11 -04
 * @desc
 */
@RestController
@RequestMapping("/share")
public class ShareController {

    @Resource
    private ShareService shareService;

    @GetMapping("/{id}")
    public BaseResult findById(@PathVariable Integer id) {
        try {
            ShareDTO shareDTO = shareService.findById(id);
            return BaseResult.success(shareDTO);
        } catch (Exception e) {
            return BaseResult.error(e.getMessage());
        }
    }

}

