package com.hoe.sentient.ws.boot.config;

import com.hoe.sentient.ws.boot.handlers.MyWebSocketHandler;
import com.hoe.sentient.ws.boot.interceptors.MyWebSocketInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Author guan
 * @Date 2023/3/7
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                //设置连接路径和处理
                .addHandler(new MyWebSocketHandler(), "/api/pushMessage2/*")
                //支持跨域
                .setAllowedOrigins("*")
                //设置拦截器
                .addInterceptors(new MyWebSocketInterceptor());

    }
}
