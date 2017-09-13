package com.example.demo.callable;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class HashMapTest {

    static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 10000000; i++) {
            executorService.submit(() -> {
                map.put(UUID.randomUUID().toString(), "");
                System.out.println(Thread.currentThread().getName() + map.size());
            });
        }

        executorService.shutdown();
    }
}
