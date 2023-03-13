package com.hoe.sentient.common.syncPubSub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 事件监听器，项目启动自动订阅事件
 * @Author guan
 * @Date 2023/3/13
 */
@Slf4j
@Component
public class DiyEventListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {
    private ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //获取所有继承AbstractEventHandler的Bean
        Map<String, AbstractEventHandler> eventHandlerMap = applicationContext.getBeansOfType(AbstractEventHandler.class);

        for (String key : eventHandlerMap.keySet()) {
            AbstractEventHandler eventHandler = eventHandlerMap.get(key);
            DiyEventEmitter.subscribe(eventHandler);
            log.info("订阅事件:"+ eventHandler);
        }
    }
}
