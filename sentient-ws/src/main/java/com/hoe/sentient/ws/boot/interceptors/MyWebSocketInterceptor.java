package com.hoe.sentient.ws.boot.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义拦截器拦截WebSocket请求
 * @Author guan
 * @Date 2023/3/7
 */
@Slf4j
public class MyWebSocketInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        log.info("WebSocket前置拦截~~");

        if (!(request instanceof ServletServerHttpRequest)) {
            return true;
        }
        String path = request.getURI().getPath();
        String[] split = path.split("/");



// HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
//
// String userName = (String) servletRequest.getSession().getAttribute("userName");
        //取出path上的userId
        String userId = split[split.length-1];
        attributes.put("userId", userId);

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        log.info("WebSocket后置拦截~~");
    }
}
