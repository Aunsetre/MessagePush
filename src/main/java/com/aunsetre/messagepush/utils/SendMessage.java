package com.aunsetre.messagepush.utils;

import com.alibaba.fastjson.JSONObject;
import com.aunsetre.messagepush.pojo.ScheduledMessage;
import com.aunsetre.messagepush.websocket.MyWebSocket;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Aunsetre
 * @date 2018-08-23
 */
@Component
@Log
public class SendMessage{
    @Resource
    private ScheduledMessage message;
    public void receiveData(ScheduledMessage message){
        try {
            MyWebSocket.sendInfo(JSONObject.toJSONString(message));
        }catch (IOException e){
            log.info("IO异常，发送失败");
        }

    }

}
