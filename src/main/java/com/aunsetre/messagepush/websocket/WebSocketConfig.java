package com.aunsetre.messagepush.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-22
 */
@Configuration
public class WebSocketConfig{


    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
