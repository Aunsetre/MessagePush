package com.aunsetre.messagepush.dao;

import com.aunsetre.messagepush.pojo.ScheduledMessage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 *
 * @author Aunsetre
 * @date 2018-08-22
 */
@Repository("dao")
public interface ScheduledMessageDAO {
     @Select("select * from `scheduledmessage` order by createDate")
     List<ScheduledMessage> getList();
}
