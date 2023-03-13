package com.hoe.sentient.common.syncPubSub.demo;

import com.hoe.sentient.common.syncPubSub.AbstractEventHandler;
import org.springframework.stereotype.Component;

/**
 * @Author guan
 * @Date 2023/3/13
 */
@Component
public class DemoDiyEventHandler extends AbstractEventHandler<DemoEvent> {
    @Override
    public void handle(DemoEvent msg) {
        System.out.println("收到订阅消息了" + msg.getAbc());

    }

}
