package com.yibao.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.yibao.common.util.BaseResult;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author yibao
 * @create 2022 -11 -16
 * @desc 自定义全局 gateway filter 处理
 */
@Order(-1)  // 值越小，过滤器顺序越靠前
@Component
public class CustomGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 示例：拦截所有请求，判断请求中是否带有 token，且值为 admin | 放行 | 拦截
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if ("admin".equals(token)) {
            // 放行
            return chain.filter(exchange);
        }
        // 拦截：禁止访问
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.FORBIDDEN);
        byte[] bytes = JSON.toJSONString(BaseResult.error("非法访问!")).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(buffer));
    }
}
