package com.yibao.sentinel.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.fastjson.JSON;
import com.yibao.common.util.BaseResult;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yibao
 * @create 2022 -11 -18
 * @desc sentinel 异常处理
 */
@Component
public class SentinelBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg = "..访问异常..";
        if (e instanceof FlowException) {
            msg = "请求被限流了!";
        } else if (e instanceof DegradeException) {
            msg = "请求被降级了!";
        } else if (e instanceof ParamFlowException) {
            msg = "热点参数被限流了!";
        } else if (e instanceof AuthorityException) {
            msg = "请求没有访问权限!";
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().print(JSON.toJSONString(BaseResult.error(msg)));
    }
}
