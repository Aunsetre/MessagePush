package com.aunsetre.messagepush.service.impl;

import com.aunsetre.messagepush.dao.ScheduledMessageDAO;
import com.aunsetre.messagepush.service.ScheduledMessageService;
import com.aunsetre.messagepush.pojo.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-22
 */
@Service("service")
public class ScheduledMessageServiceImpl implements ScheduledMessageService {
    @Resource
    private ScheduledMessageDAO dao;

    @Override
    public List<Message> getList() {
        return dao.getList();
    }
    public void sortQueue(){

    }
}
