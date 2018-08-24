package com.aunsetre.messagepush.utils;

import com.aunsetre.messagepush.service.ScheduledMessageService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-21
 */
@Configuration
public class MessageProcessor {
    private boolean flag=false;
    @Resource
    private ScheduledMessageService service;
    @Async("asycServiceThreadPool")
    public void trans(){


    }
}
