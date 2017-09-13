package com.example.demo.guava;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenLY on 2017-09-08.
 */
public class Main {

    public static void main(String[] args) {

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Futures.addCallback(listeningExecutorService.submit(new Task()), new TaskFutureCallback(listeningExecutorService, executor), executor);

        final Thread mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the main thread state is " + mainThread.getState());
        }).start();
    }
}
