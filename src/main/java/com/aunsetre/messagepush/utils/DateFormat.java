package com.aunsetre.messagepush.utils;

import lombok.extern.java.Log;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类提供Quartz的cron表达式与Date之间的转换
 * @author Aunsetre
 * @date 2018-08-24
 */
@Log
public class DateFormat {
    private static final String DATE_FORMAT = "yyyy-MM-dd hh-mm-ss";
    /***
     * 将java.util.Date转换成毫秒
     * @param date 时间
     * @return  返回毫秒
     */
   @NotNull public static Long getTimeMillis(@NotNull Date date) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT)
                .parse(new SimpleDateFormat(DATE_FORMAT)
                        .format(date)).getTime();
    }
    /**
     *
     * @param date
     * @return 返回java.util.Date
     */
    @NotNull public static Date getDate(@NotNull String date) {
        return new Date(Long.parseLong(date));
    }

    public static Long getTimeMillisBetWeen(@NotNull Date date) throws ParseException {
        return getTimeMillis(date)-getTimeMillis(new Date());
    }

    public static String cron(@NotNull Date date) {
        return new SimpleDateFormat("ss mm HH dd MM ").format(date);

    }
}
