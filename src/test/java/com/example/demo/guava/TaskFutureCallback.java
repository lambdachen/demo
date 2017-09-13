package com.example.demo.guava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutorService;

/**
 * Created by ChenLY on 2017-09-08.
 */
public class TaskFutureCallback implements FutureCallback<String> {

    private ListeningExecutorService listeningExecutorService;

    private ExecutorService executorService;

    public TaskFutureCallback(ListeningExecutorService listeningExecutorService, ExecutorService executorService) {
        this.listeningExecutorService = listeningExecutorService;
        this.executorService = executorService;
    }

    @Override
    public void onSuccess(@Nullable String result) {
        System.out.println("callback successfully and the result is " + result + " and the current thread is " + Thread.currentThread().getName());
        listeningExecutorService.shutdown();
        executorService.shutdown();
    }

    @Override
    public void onFailure(Throwable t) {
        System.out.println("callback fail and the exception message is " + t.getMessage());
        listeningExecutorService.shutdown();
        executorService.shutdown();
    }
}
