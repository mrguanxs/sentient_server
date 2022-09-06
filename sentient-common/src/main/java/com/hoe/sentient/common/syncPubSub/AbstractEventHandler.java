package com.hoe.sentient.common.syncPubSub;

/**
 * @Author Gavin
 * @Date 2022/9/6
 */

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractEventHandler<T extends AbstractEvent> {

    public void onMessage(T event){
        log.info("接收到订阅消息,event:{}", JSONObject.toJSONString(event));
        try {
            handle(event);
        }catch (Exception e){
            log.error("接收到订阅消息,处理失败,event:{},失败原因:{}", JSONObject.toJSONString(event), e.getMessage(), e);
        }
        log.info("接收到订阅消息,处理成功");
    }

    public abstract void handle(T msg);
}
