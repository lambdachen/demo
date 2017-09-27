package com.example.demo.concurrent;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by ChenLY on 2017-09-19.
 */
public class Main {

    @Test
    public void test() throws Exception {

    }

    @Test
    public void test1() throws Exception {
        System.out.println(TimeUnit.HOURS.toDays(24));
        System.out.println(TimeUnit.MINUTES.toDays(24 * 60));
        System.out.println(TimeUnit.MINUTES.toDays(23 * 60));
    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<>(Arrays.asList("1", "2"));
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
        System.out.println(a);
    }

    @Test
    public void test3() throws Exception {
        final int num = 1;
        Consumer<Integer> consumer = a -> System.out.println(a + num);
        Consumer<Integer> after = consumer.andThen(a -> System.out.println(a));
        after.accept(1);
    }

    @Test
    public void test4() throws Exception {
        final String result = "hello world";
        Supplier<String> supplier = () -> result;
        System.out.println(supplier.get());
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void test5() throws Exception {
        CountDownLatch latch = new CountDownLatch(10);
        String date = "2011-01-01 11:11:11";
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(sdf.format(sdf.parse(date)));
                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println("main thread is terminated");
    }
}
