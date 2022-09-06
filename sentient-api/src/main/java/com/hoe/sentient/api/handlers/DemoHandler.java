package com.hoe.sentient.api.handlers;

import com.ziiforce.foundation.mq.base.event.AbstractQueueMessageEventHandler;
import com.ziiforce.foundation.mq.base.eventbeans.demo.DemoQueueEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author Gavin
 * @Date 2022/8/31
 */
@Component
@Slf4j
public class DemoHandler extends AbstractQueueMessageEventHandler<DemoQueueEvent> {

    @Override
    public void handle(DemoQueueEvent event) {
        log.info("message:" + event.getName());
        throw new RuntimeException("bububu");
    }
}
