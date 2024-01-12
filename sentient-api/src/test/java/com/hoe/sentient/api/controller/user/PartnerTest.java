package com.hoe.sentient.api.controller.user;

import com.hoe.sentient.api.BaseTest;
import com.hoe.sentient.common.base.ItemListRecord;
import com.hoe.sentient.facade.user.PartnerFacade;
import com.hoe.sentient.facade.user.dto.PartnerDTO;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * PartnerTest
 *
 * @Author Gavin
 * @Date 2021/2/2 5:56 下午
 */
public class PartnerTest extends BaseTest {
    @Resource
    private PartnerFacade partnerFacade;

    @Test
    public void queryPartners() {
        ItemListRecord<PartnerDTO> partnerDTOItemListRecord = partnerFacade.queryPartners(1L);
        System.out.println(partnerDTOItemListRecord);
    }

//    @Resource
//    private MessageEventPublisher eventPublisher;
//
//    @Test
//    public void workQueueTest() {
//        DemoQueueEvent demoEvent = new DemoQueueEvent();
//        demoEvent.setName("bui～bu～bu～");
//        eventPublisher.send(demoEvent);
//    }
//
//    @Test
//    public void fanoutTest() {
//        DemoFanoutEvent demoEvent = new DemoFanoutEvent();
//        demoEvent.setName("demoFanoutMsg1");
//        eventPublisher.send(demoEvent);
//    }
//
//    @Test
//    public void directTest() {
//        DemoDirectEvent demoEvent = new DemoDirectEvent();
//        demoEvent.setName("demoDirectMsg");
//        eventPublisher.send(demoEvent);
//    }
//
//    @Test
//    public void topicTest() {
//        DemoTopicEvent2 demoEvent = new DemoTopicEvent2();
//        demoEvent.setName("demoTopicMsg111");
//        eventPublisher.send(demoEvent);
//    }
}
