package com.aunsetre.messagepush;

import com.aunsetre.messagepush.pojo.ScheduledMessage;
import com.aunsetre.messagepush.scheduledtasks.ScheduledService;
import com.aunsetre.messagepush.service.ScheduledMessageService;
import com.aunsetre.messagepush.utils.MySqlConnent;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MessagepushApplicationTests {

    @Resource
    private ScheduledMessageService service;


    @Test
    public void contextLoads() throws SQLException, ClassNotFoundException {

        List<ScheduledMessage> list = service.getList();
        for (ScheduledMessage sp : list) {
            log.info(sp.getContent() + "\n" + sp.getCreateAuthor() + "\n" + sp.getCreateDate() + "\n"
                    + sp.getId() + "\n" + sp.getTitle());
        }
    }
    @Test
    public void getConn() throws SQLException, ClassNotFoundException {
        MySqlConnent.getInstace().getConnection();
    }

    @Test
    public void ScheduledService(){
        ScheduledService scheduledService=new ScheduledService();
    }
}