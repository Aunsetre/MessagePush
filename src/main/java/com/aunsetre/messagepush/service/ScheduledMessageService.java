package com.aunsetre.messagepush.service;

import com.aunsetre.messagepush.pojo.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-22
 */

public interface ScheduledMessageService {
    /**
     * 查询列表
     * @return List
     * @throws SQLException 查询异常
     * @throws ClassNotFoundException 找不到异常
     */
    List<Message> getList() throws SQLException, ClassNotFoundException;

}
