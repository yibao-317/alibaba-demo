package com.yibao.contentcenter.service;

import com.yibao.common.dto.ShareDTO;

public interface ShareService {

    /**
     * 根据 id 查询分享表信息
     * @param id
     * @return
     * @throws Exception
     */
    public ShareDTO findById(Integer id) throws Exception;

}
