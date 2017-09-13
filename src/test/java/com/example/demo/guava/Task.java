package com.example.demo.guava;

import java.util.concurrent.Callable;

/**
 * Created by ChenLY on 2017-09-08.
 */
public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("do call and the thread is " + Thread.currentThread().getName());
        Thread.sleep(3000);
        throw new RuntimeException("do test");
        //return "ok";
    }
}
