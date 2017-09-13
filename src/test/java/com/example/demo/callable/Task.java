package com.example.demo.callable;

import java.util.concurrent.Callable;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class Task implements Callable<String> {

    private String result;

    public Task(String result) {
        this.result = result;
    }

    @Override
    public String call() throws Exception {
        System.out.println("ok");
        Thread.sleep(3000);
        return result;
    }
}
