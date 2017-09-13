package com.example.demo.callable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class CallTest {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new Task("task1"));
        System.out.println(sdf.format(new Date()) + ": begin");
        try {
            System.out.println("future isDone is " + future.isDone());
            final Thread mainThread = Thread.currentThread();
            new Thread(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("the main thread state is " + mainThread.getState());
            }).start();
            System.out.println(future.get());
            System.out.println("the future has get and the main thread state is " + mainThread.getState());
            System.out.println(sdf.format(new Date()) + ": end");
        } catch (Exception e) {
            System.out.println("future get result timeout");
        } finally {
            executorService.shutdown();
            System.out.println(executorService.isShutdown());
            if (executorService.isShutdown()) {

            }
        }
    }
}
