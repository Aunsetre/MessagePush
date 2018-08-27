package com.aunsetre.messagepush;

import com.aunsetre.messagepush.pojo.Message;
import com.aunsetre.messagepush.scheduledtasks.QuartzManager;
import com.aunsetre.messagepush.scheduledtasks.ScheduledTask;
import com.aunsetre.messagepush.service.ScheduledMessageService;
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
public class MessagePushApplicationTests {

    @Resource
    private ScheduledMessageService service;
    @Resource
    private QuartzManager quartzManager;


    public static String JOB_NAME = "动态任务调度";
    public static String TRIGGER_NAME = "动态任务触发器";
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";
    @Test
    public void contextLoads() throws SQLException, ClassNotFoundException {

        List<Message> list = service.getList();
        for (Message sp : list) {
            log.info(sp.getContent() + "\n" + sp.getCreateAuthor() + "\n" + sp.getCreateDate() + "\n"
                    + sp.getId() + "\n" + sp.getTitle());
        }
    }
    @Test
    public void test(){
    try {
        System.out.println("【系统启动】开始(每1秒输出一次)...");
        quartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, ScheduledTask.class, "0 25 21 26 8 ? 2018-2018");

        //Thread.sleep(5000);
       // System.out.println("【修改时间】开始(每5秒输出一次)...");
       // quartzManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, "0/5 * * * * ?");

        /*Thread.sleep(6000);
        System.out.println("【移除定时】开始...");
        quartzManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME);
        System.out.println("【移除定时】成功");*/
        } catch (Exception e) {
        e.printStackTrace();
        }
    }


}