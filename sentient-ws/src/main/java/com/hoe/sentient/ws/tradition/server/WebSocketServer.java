package com.hoe.sentient.ws.tradition.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * websocket的处理类。
 * 作用相当于HTTP请求
 * 中的controller
 * @author guan
 */
@Component
@Slf4j
@ServerEndpoint("/api/websocket/{sid}")
public class WebSocketServer {
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSockets = new CopyOnWriteArraySet<WebSocketServer>();
    /**
     * 用来存在线连接用户信息
     */
    private static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<String, Session>();


    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 接收sid
     */
    private String sid;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        try {
            this.session = session;
            this.sid = sid;
            webSockets.add(this);
            sessionPool.put(sid, session);
            log.info("【websocket消息】有新的连接,sid:{},总数为:" + sid, webSockets.size());
            session.getAsyncRemote().sendText("连接成功");
        } catch (Exception e) {
            log.error("【websocket消息】开启连接异常,sid:{}", sid, e);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.sid);
            log.info("【websocket消息】连接断开,sid:{},总数为:" + this.sid, webSockets.size());
        }catch (Exception e){
            log.error("【websocket消息】断开连接异常,sid:{}", this.sid, e);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端消息,sid:{}, msg:{}", this.sid, message);
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("【websocket消息】发生错误, sid:{}, 原因:{}", this.sid, error.getMessage(), error);
    }

    /**
     * 发消息
     */
    public static void sendMsg(String sid, String message){
        Session session = sessionPool.get(sid);
        if(session != null) {
            session.getAsyncRemote().sendText(message);
        }else {
            log.error("【websocket消息】连接未建立,sid:{}", sid);
        }
    }

    /**
     * 群发消息
     */
    public static void sendBatch(String message) {
        log.info("【websocket消息】批量推送内容:" + message);
        for (WebSocketServer item : webSockets) {
            try {
                item.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                log.error("【websocket消息】批量推送消息失败:sid:{}, message:{}", item.sid, message);
            }
        }
    }

}


