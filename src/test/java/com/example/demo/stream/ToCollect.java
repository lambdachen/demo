package com.example.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ChenLY on 2017-09-18.
 */
public class ToCollect {

    @Test
    public void test1() throws Exception {
        List<Integer> origin = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> actual = origin.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        System.out.println(origin);
        System.out.println(actual);

        List<String> list = Stream.of("one", "two", "three", "four")
                .filter(s -> s.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test2() throws Exception {
        List<String> origin = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        String result = origin.stream().collect(Collectors.joining(","));
        System.out.println("result is " + result);
    }

    @Test
    public void test3() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("the thread " + Thread.currentThread().getName() + " begin");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the thread " + Thread.currentThread().getName() + " end");
            latch.countDown();
        }).start();
        latch.await();
        System.out.println(Thread.currentThread().getName());
    }
}
