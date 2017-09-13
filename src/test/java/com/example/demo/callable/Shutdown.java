package com.example.demo.callable;

import jdk.management.resource.internal.inst.ThreadRMHooks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class Shutdown {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future future = executorService.submit(() -> {
            boolean isRun = true;
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //isRun = false;
                    //break;
                    System.out.println(Thread.currentThread().getState());
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getState());
                }
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });

        Thread.sleep(3000);
        executorService.shutdown();
        System.out.println(future.get());

        executorService.shutdownNow();
    }
}
