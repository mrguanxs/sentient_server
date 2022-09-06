//package com.hoe.sentient.api.handlers;
//
//import com.ziiforce.foundation.mq.base.event.AbstractTopicMessageEventHandler;
//import com.ziiforce.foundation.mq.base.eventbeans.demo.DemoTopicEvent2;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author Gavin
// * @Date 2022/8/31
// */
//@Component
//@Slf4j
//public class DemoTopicHandler2 extends AbstractTopicMessageEventHandler<DemoTopicEvent2> {
//
//    @Override
//    public void handle(DemoTopicEvent2 event) {
//        System.out.println("topic2:" + event.getName());
//    }
//
//    @Override
//    public List<String> getRoutingKeys() {
//        ArrayList<String> routingKeys = new ArrayList<>();
//        routingKeys.add("topic.abc.def");
//        return routingKeys;
//    }
//
//}
