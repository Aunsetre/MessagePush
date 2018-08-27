package com.aunsetre.messagepush.controller;

import com.aunsetre.messagepush.pojo.Message;
import com.aunsetre.messagepush.scheduledtasks.QuartzManager;
import com.aunsetre.messagepush.scheduledtasks.ScheduledTask;
import com.aunsetre.messagepush.scheduledtasks.TaskDetail;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Aunsetre
 * @date 2018-08-26
 */
@Controller
@Log
public class IndexController
{
    @Resource
    private TaskDetail taskDetail;

    @RequestMapping("/test")
    @ResponseBody
    public int anInt()
    {
        taskDetail.execute();
        return 1;
    }
}
