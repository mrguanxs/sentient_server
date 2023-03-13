package com.hoe.sentient.api.event;

import com.hoe.sentient.api.BaseTest;
import com.hoe.sentient.common.syncPubSub.DiyEventEmitter;
import com.hoe.sentient.common.syncPubSub.demo.DemoEvent;
import org.junit.Test;

/**
 * @Author guan
 * @Date 2023/3/13
 */
public class EventTest extends BaseTest {

    @Test
    public void test(){
        DemoEvent demoEvent = new DemoEvent();
        demoEvent.setAbc("hhhh");

        DiyEventEmitter.publish(demoEvent);

    }

}
