package com.example.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<String> resultFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }, executor);

        resultFuture.thenAccept((t) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(t);
        });
        executor.shutdown();
        System.out.println("the main thread is terminated");
    }
}
