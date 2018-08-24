package com.aunsetre.messagepush;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.aunsetre.messagepush.dao")
@EnableScheduling
@EnableAsync
public class MessagePushApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagePushApplication.class, args);
    }
}
