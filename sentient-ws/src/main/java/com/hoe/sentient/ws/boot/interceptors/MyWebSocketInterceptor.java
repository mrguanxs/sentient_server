package com.hoe.sentient.ws.boot.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

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

        //通过以下两种方式可放入token进行权限认证

//        //方式一，获取query中数据方法
//        //获取query数据,前端将数据放入地址栏中，例如：ws://localhost:8089/api/pushMessage2/123?userName=zhangsan
//        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
//        String userName = (String) servletRequest.getParameter("userName");


        //方式二，获取header中数据方法
        //获取header中Sec-Websocket-Protocol,前端通过此种方式创建webSocket: var socket = new WebSocket(socketUrl, ['token', 'clientId']);
        String protocols = ((ServletServerHttpRequest) request).getServletRequest().getHeader("Sec-Websocket-Protocol");//需要返回相同的header否则连接会断开
        response.getHeaders().add("Sec-Websocket-Protocol", protocols);//可获取到['token', 'clientId']

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
