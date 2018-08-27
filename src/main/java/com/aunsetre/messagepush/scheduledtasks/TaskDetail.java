package com.aunsetre.messagepush.scheduledtasks;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

/**
 * @author Aunsetre
 * @date 2018-08-26
 */
@Component
@Log
public class TaskDetail {

    private QuartzManager quartzManager=new QuartzManager();
    public  String JOB_NAME = System.currentTimeMillis()+"动态任务调度";
    public  String TRIGGER_GROUP_NAME = System.currentTimeMillis()+"XLXXCC_JOB_GROUP";
    public void execute(){
        quartzManager.addJob(JOB_NAME, System.currentTimeMillis()+"", System.currentTimeMillis()+"", TRIGGER_GROUP_NAME,
                ScheduledTask.class, "0 07 17 27 8 ? 2018-2018");
        quartzManager.addJob(JOB_NAME, System.currentTimeMillis()+"", System.currentTimeMillis()+"", TRIGGER_GROUP_NAME,
                ScheduledTask.class, "3 07 17 27 8 ? 2018-2018");
        //将前端数据传入JOb
        //放入数据库
    }
}
