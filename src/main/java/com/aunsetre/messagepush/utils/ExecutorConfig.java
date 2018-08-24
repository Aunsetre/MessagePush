package com.aunsetre.messagepush.utils;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 *
 * 线程池配置
 *
 * @author Aunsetre
 * @date 2018-08-22
 */
/*@Configuration
@EnableAsync*/
@Log
public class ExecutorConfig {

    public Executor asyncServiceThreadPool(){

        ThreadPoolTaskExecutor  executor=new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors()*2);
        //配置最大线程数
        executor.setMaxPoolSize(5);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程名前缀
        executor.setThreadNamePrefix("asyc-service-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        log.info("执行任务");
        executor.initialize();
        return executor;
    }
}
