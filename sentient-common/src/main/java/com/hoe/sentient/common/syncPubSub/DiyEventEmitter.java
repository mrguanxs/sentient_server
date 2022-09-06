package com.hoe.sentient.common.syncPubSub;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @Author Gavin
 * @Date 2022/9/6
 */
public class DiyEventEmitter{
    private static Map<Class, Set<AbstractEventHandler>> eventHandlers = new HashMap<>();

    public <T extends AbstractEvent> void subscribe(AbstractEventHandler<T> abstractEventHandler){
        Class<?> eventClass = getActualTypeArgument(abstractEventHandler.getClass());
        Set<AbstractEventHandler> handlerSet = eventHandlers.get(eventClass);
        if(handlerSet == null){
            handlerSet = new HashSet<>();
        }
        handlerSet.add(abstractEventHandler);
        if(!eventHandlers.containsKey(eventClass)){
            eventHandlers.put(eventClass, handlerSet);
        }
    }

    public <T extends AbstractEvent> void unSubscribe(AbstractEventHandler<T> abstractEventHandler){
        Class<?> eventClass = getActualTypeArgument(abstractEventHandler.getClass());
        if(eventHandlers.containsKey(eventClass)){
            Set<AbstractEventHandler> handlerSet = eventHandlers.get(eventClass);
            handlerSet.remove(abstractEventHandler);
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

    private static volatile DiyEventEmitter instance = getInstance();
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
