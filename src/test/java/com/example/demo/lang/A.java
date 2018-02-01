package com.example.demo.lang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ChenLY on 2018/1/22.
 */
public class A {
    private static Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            int index = 0;
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " run this");
                    TimeUnit.SECONDS.sleep(60);
                    while (true) {
                        index++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
