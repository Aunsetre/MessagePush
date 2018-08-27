package com.aunsetre.messagepush.scheduledtasks;

import com.aunsetre.messagepush.pojo.Message;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Aunsetre
 * @date 2018-08-25
 */
@Component
public class ScheduledTask implements Job {
    @Resource
    private Message message;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println(new Date() + ": doing something...");

    }
}
