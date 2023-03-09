package com.hoe.sentient.common.redisPubSub.listeners;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @Author guan
 * @Date 2023/3/8
 */
public class RedisDemoListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("监听到Redis消息");
        String body = new String(message.getBody());
        String channel = new String(message.getChannel());
        String channel2 = new String(bytes);
        System.out.println(body);
        System.out.println(channel);
        System.out.println(channel2);
    }
}
