package com.yibao.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author yibao
 * @create 2022 -11 -16
 * @desc 自定义全局 gateway filter
 */
@Order(-1)  // 值越小，过滤器顺序越靠前
@Component
public class CustomGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 示例：拦截所有请求，判断请求中是否带有 token，且值为 admin | 放行 | 拦截
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        String token = queryParams.getFirst("token");
        if ("admin".equals(token)) {
            // 放行
            return chain.filter(exchange);
        }
        // 拦截：禁止访问
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        return exchange.getResponse().setComplete();
    }
}
