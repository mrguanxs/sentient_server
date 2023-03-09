package com.hoe.sentient.common.syncPubSub;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单服务事件总线,用于解耦
 * TODO 项目启动的时候自动订阅所有handlers
 * @Author Gavin
 * @Date 2022/9/6
 */
public class DiyEventEmitter{
    private static Map<Class, Set<AbstractEventHandler>> eventHandlers = new ConcurrentHashMap<>();

    public <T extends AbstractEvent> void subscribe(AbstractEventHandler<T> abstractEventHandler){
        Class<?> eventClass = getActualTypeArgument(abstractEventHandler.getClass());
        synchronized (DiyEventEmitter.class) {
            Set<AbstractEventHandler> handlerSet = eventHandlers.get(eventClass);
            if (handlerSet == null) {
                handlerSet = new HashSet<>();
            }
            handlerSet.add(abstractEventHandler);
            if (!eventHandlers.containsKey(eventClass)) {
                eventHandlers.put(eventClass, handlerSet);
            }
        }
    }

    public <T extends AbstractEvent> void unSubscribe(AbstractEventHandler<T> eventHandler){
        Class<?> eventClass = getActualTypeArgument(eventHandler.getClass());
        if(eventHandlers.containsKey(eventClass)){
            Set<AbstractEventHandler> handlerSet = eventHandlers.get(eventClass);
            if(handlerSet != null) {
                handlerSet.remove(eventHandler);
            }
        }
    }

    public <T extends AbstractEvent> void publish(T event){
        Class<? extends AbstractEvent> eventClass = event.getClass();
        Set<AbstractEventHandler> abstractEventHandlerSet = eventHandlers.get(eventClass);
        if(!CollectionUtils.isEmpty(abstractEventHandlerSet)){
            for (AbstractEventHandler abstractEventHandler : abstractEventHandlerSet) {
                abstractEventHandler.onMessage(event);
            }
        }
    }


    /**
     * 获取泛型类Class对象，不是泛型类则返回null
     */
    public static Class<?> getActualTypeArgument(Class<?> clazz) {
        Class<?> entityClass = null;
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass)
                    .getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                entityClass = (Class<?>) actualTypeArguments[0];
            }
        }

        return entityClass;
    }

    private static DiyEventEmitter instance;
    private DiyEventEmitter() {
    }
    private static DiyEventEmitter getInstance(){
        if(instance == null){
            synchronized (DiyEventEmitter.class){
                if(instance == null){
                    instance = new DiyEventEmitter();
                }
            }
        }
        return instance;
    }
}
