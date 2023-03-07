package com.hoe.sentient.ws.boot.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author guan
 2023/3/7
 */
@Slf4j
public class MyWebSocketHandler implements WebSocketHandler {

    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。*/
    private static final ConcurrentHashMap<String, WebSocketSession> webSocketMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("开始链接");
        String userId = session.getAttributes().get("userId").toString();

        webSocketMap.put(userId, session);

        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            //加入set中
            webSocketMap.put(userId,session);
        }else{
            //加入set中
            webSocketMap.put(userId,session);
            //在线数加1
            addOnlineCount();
        }
        log.info("成功建立连接");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String msg = message.getPayload().toString();
        if(!StringUtils.isEmpty(msg)){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(msg);
                //追加发送人(防止串改)
                String userId = getUserId(session);
                jsonObject.put("fromUserId",userId);
                String toUserId=jsonObject.getString("toUserId");
                //传送给对应toUserId用户的websocket
                sendInfo(msg, toUserId);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        log.info("发送消息:{}", msg);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable e) throws Exception {
        log.info("链接出错:{}", e.getMessage(), e);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("链接关闭");

        String userId = session.getAttributes().get("userId").toString();
        if(webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            subOnlineCount();
        }
    }

    // 支持分片消息
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


    /**
     * 获得此时的
     * 在线人数
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 在线人
     * 数加1
     */
    public static synchronized void addOnlineCount() {
        MyWebSocketHandler.onlineCount++;
    }

    /**
     * 在线人
     * 数减1
     */
    public static synchronized void subOnlineCount() {
        MyWebSocketHandler.onlineCount--;
    }

    /**
     * 发送自定义消息
     **/
    public static void sendInfo(String message, String userId) {
        log.info("发送消息到:"+userId+"，报文:"+message);
        if(!StringUtils.isEmpty(userId) && webSocketMap.containsKey(userId)){
            try {
                webSocketMap.get(userId).sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            log.error("用户"+userId+",不在线！");
        }
    }

    /**
     * 广播消息
     * @param message
     */
    public static void fanoutMessage(String message) {
        log.info("广播消息:"+"，报文:"+message);
        webSocketMap.keySet().forEach(t->sendInfo(message, t));
    }

    public static String getUserId(WebSocketSession session){
        return session.getAttributes().get("userId").toString();
    }
}
