package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ChenLY on 2017-09-13.
 */
public class ThreadTest3 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(() -> "done");
        System.out.println(future.get());
        executorService.shutdown();
    }

}
