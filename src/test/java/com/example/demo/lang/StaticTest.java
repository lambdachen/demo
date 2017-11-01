package com.example.demo.lang;

/**
 * Created by ChenLY on 2017-10-27.
 */
public class StaticTest {

    static {
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
    }
}
