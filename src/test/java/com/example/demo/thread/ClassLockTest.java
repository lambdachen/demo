package com.example.demo.thread;

/**
 * Created by ChenLY on 2017-10-23.
 */
public class ClassLockTest {

    private static String str = "hello world";

    public synchronized static void print() {
        System.out.println("hello world");
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (ClassLockTest.class) {
                System.out.println("thread-a get the class lock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-a release the class lock");
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new ClassLockTest().print();
        }).start();
    }
}
