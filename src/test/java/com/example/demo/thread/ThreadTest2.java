package com.example.demo.thread;

/**
 * Created by ChenLY on 2017-09-06.
 */
public class ThreadTest2 {

    public static void main(String[] args) throws InterruptedException {

        Thread at = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("at test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        at.start();

        synchronized (System.out) {
            System.out.println("test");
            Thread.sleep(2000);
            System.out.println("at state is " + at.getState());
            Thread.sleep(8000);
        }
    }
}
