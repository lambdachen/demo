package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenliuyang on 2017-08-29.
 */
public class Task {

    @Scheduled(cron="*/5 * * * * ?")
    public void execute1() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":" + Thread.currentThread().getName() + " execute1");
    }

    @Scheduled(cron="*/5 * * * * ?")
    public void execute2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":" + Thread.currentThread().getName() + " execute2");
    }
}
