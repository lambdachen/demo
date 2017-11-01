package com.example.demo.inner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by ChenLY on 2017-09-13.
 */
public class LambdaTest {

    static LambdaTest test = null;

    Runnable r1 = () -> {
        System.out.println(this);
        test = this;
    };

    Runnable r2 = () -> System.out.println(toString());

    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    Runnable r4 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    @Override
    public String toString() {
        return "hello world!";
    }

    public static void main(String[] args) {
        LambdaTest t1 = new LambdaTest();
        t1.r1.run();
        System.out.println(t1 == test);
        new LambdaTest().r2.run();
        new LambdaTest().r3.run();
        new LambdaTest().r4.run();
    }

    @Test
    public void test1() throws Exception {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        long count = list.stream().count();
        int sum = list.stream().filter(Objects::nonNull).mapToInt(s -> s + 1).sum();
        System.out.println(count);
        System.out.println(sum);
    }
}
