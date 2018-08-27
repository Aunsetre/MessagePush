package com.aunsetre.messagepush.utils.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Aunsetre
 * @date 2018-08-24
 */
public class ExecutorSch {
   public void asyncServiceThreadPool(){
       ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
// 任务需要 2000 ms 才能执行完毕
       TimerTask timerTask = new TimerTask(2000);

       System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

       // 延时 1 秒后，按 3 秒的周期执行任务

       timer.scheduleAtFixedRate(timerTask, 1000, 3000, TimeUnit.MILLISECONDS);
   }
    private static class TimerTask implements Runnable {

        private final int sleepTime;
        private final SimpleDateFormat dateFormat;

        public TimerTask(int sleepTime) {
            this.sleepTime = sleepTime;
            dateFormat = new SimpleDateFormat("HH:mm:ss");
        }

        @Override
        public void run() {
            System.out.println("任务开始，当前时间：" + dateFormat.format(new Date()));

            try {
                System.out.println("模拟任务运行...");
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }

            System.out.println("任务结束，当前时间：" + dateFormat.format(new Date()));
            System.out.println();
        }

    }

}
