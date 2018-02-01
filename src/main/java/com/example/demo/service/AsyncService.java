package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ChenLY on 2018/1/19.
 */
@Service
public class AsyncService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

    private AtomicInteger userId = new AtomicInteger(0);

    @Async
    public ListenableFuture<User> getUser() {
        LOGGER.warn("{}, getUser", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AsyncResult asyncResult = new AsyncResult<>(new User(userId.getAndIncrement(), "jack"));
        /*asyncResult.addCallback((result) -> {
            LOGGER.info("{}, the result is {}", Thread.currentThread().getName(), result);
        }, (ex) -> {
            LOGGER.info("{}, the ex is {}", Thread.currentThread().getName(), ex.getMessage());
        });*/
        return asyncResult;
    }

    public User getSyncUser() {
        LOGGER.warn("{}, getSyncUser", Thread.currentThread().getName());
        return new User(2, "rose");
    }
}
