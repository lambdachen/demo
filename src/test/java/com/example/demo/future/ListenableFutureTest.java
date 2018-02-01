package com.example.demo.future;

import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenLY on 2018/1/18.
 */
public class ListenableFutureTest {

    public static void main(String[] args) {
        ListenableFutureTask<String> futureTask = new ListenableFutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName());
            return "test";
        });
        futureTask.addCallback(result -> System.out.println(Thread.currentThread().getName() + ", " + result),
                ex -> System.out.println(ex.getMessage()));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(futureTask);
        executorService.shutdown();
    }
}
