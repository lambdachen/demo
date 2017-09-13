package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ChenLY on 2017-09-11.
 */
public class Task2 {

    @Scheduled(cron = "*/5 * * * * ?")
    public void execute() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":" + Thread.currentThread().getName() + " execute3");
    }
}
