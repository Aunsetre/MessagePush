package com.aunsetre.messagepush.service;

import com.aunsetre.messagepush.pojo.ScheduledMessage;

import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-22
 */

public interface ScheduledMessageService {
    List<ScheduledMessage> getList() throws SQLException, ClassNotFoundException;

}
