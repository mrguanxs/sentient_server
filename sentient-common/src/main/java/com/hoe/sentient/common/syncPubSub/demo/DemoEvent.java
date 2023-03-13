package com.hoe.sentient.common.syncPubSub.demo;

import com.hoe.sentient.common.syncPubSub.AbstractEvent;
import lombok.Data;

/**
 * @Author guan
 * @Date 2023/3/13
 */
@Data
public class DemoEvent extends AbstractEvent {
    private String abc;
}
