package com.hoe.sentient.common.redisPubSub.listeners;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author guan
 * @Date 2023/3/8
 */
@Component
public class RedisPub {

    @Resource
    private RedisTemplate redisTemplate;

    public void pubMsg(String channel, String msg){
        redisTemplate.convertAndSend(channel, msg);
    }

}
