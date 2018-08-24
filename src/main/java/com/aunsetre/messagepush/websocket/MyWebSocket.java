package com.aunsetre.messagepush.websocket;

import com.aunsetre.messagepush.utils.SendMessage;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-22
 */
@ServerEndpoint(value = "/websocket")
@Component
@Log
public class MyWebSocket {
    @Resource
    private SendMessage sendMessage;
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     **/
    private static int onlineCount = 0;

    /**
     * concurrent包的线程安全Map，用来存放每个客户端对应的MyWebSocket对象。
     **/
    private static ConcurrentHashMap<String,MyWebSocket> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     **/
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //加入set中
        webSocketSet.put(session.getId(),this);
        //在线数加1
        addOnlineCount();
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
            sendMessage("6666");

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(webSocketSet);
        //在线数减1
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:" + message);

        //群发消息
        for (String key : webSocketSet.keySet()) {

                MyWebSocket socket=webSocketSet.get(key);
                socket.sendMessage(message);

        }
    }

    /**
     * 发生错误时调用
     * */
     @OnError
     public void onError(Session session, Throwable error) {
     log.info("发生错误");
     error.printStackTrace();
     }

    /**
     * 发送信息
     * @param message
     * @throws IOException
     */
     public void sendMessage(String message) {
    //this.session.getBasicRemote().sendText(message);
     this.session.getAsyncRemote().sendText(message);
     }


     /**
      * 群发自定义消息
      * */

    public static void sendInfo(String message)  {
        for (String key : webSocketSet.keySet()) {

                MyWebSocket socket=webSocketSet.get(key);
                socket.sendMessage(message);

        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
