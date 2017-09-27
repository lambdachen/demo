package com.example.demo.inner;

/**
 * Created by ChenLY on 2017-09-13.
 */
public class LambdaTest {

    Runnable r1 = () -> System.out.println(this);

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
        new LambdaTest().r1.run();
        new LambdaTest().r2.run();
        new LambdaTest().r3.run();
        new LambdaTest().r4.run();
    }
}
