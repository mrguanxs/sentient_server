package com.hoe.sentient.api.redis;

import com.hoe.sentient.api.BaseTest;
import com.hoe.sentient.common.redisPubSub.config.RedisConfig;
import com.hoe.sentient.common.redisPubSub.listeners.RedisPub;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Author guan
 * @Date 2023/3/8
 */
public class RedisTest extends BaseTest {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedisPub redisPub;

    @Test
    public void test(){
        Object abc = redisTemplate.opsForValue().get("abc");
        System.out.println(abc);
        redisTemplate.opsForValue().set("abc","");
        abc = redisTemplate.opsForValue().get("abc");
        System.out.println(abc);
    }

    @Test
    public void publishTest(){
        redisPub.pubMsg(RedisConfig.REDIS_DEMO_CHANNEL,"hello,你订阅了Redis!");
    }
}
