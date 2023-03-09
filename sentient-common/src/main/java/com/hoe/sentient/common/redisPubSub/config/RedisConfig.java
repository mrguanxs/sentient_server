package com.hoe.sentient.common.redisPubSub.config;

import com.hoe.sentient.common.redisPubSub.listeners.RedisDemoListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author guan
 * @Date 2023/3/8
 */
@Configuration
public class RedisConfig {

    /**
     * 配置Redis
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(factory);
        //设置键值默认序列化方式
        //RedisTemplate有自己的默认序列化的方式，不过使用默认方式，会在redis客户端查看的时候出现乱码，不便与使用，我们这里用fastjson库
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setDefaultSerializer(stringSerializer);
        return redisTemplate;
    }

    public static final String REDIS_DEMO_CHANNEL = "REDIS_DEMO_CHANNEL";

    /**
     * redis 消息监听
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        //设置订阅topic
        redisMessageListenerContainer.addMessageListener(new RedisDemoListener(), new ChannelTopic(REDIS_DEMO_CHANNEL));
        return redisMessageListenerContainer;
    }
}
