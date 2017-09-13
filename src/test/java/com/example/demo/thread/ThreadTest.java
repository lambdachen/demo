package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by ChenLY on 2017-09-06.
 */
public class ThreadTest {

    private static final Object alock = new Object();

    private static final Object block = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread at = new Thread(() -> {
            synchronized (alock) {
                System.out.println("at get lock a");
                synchronized (block) {
                    System.out.println("at get lock b");
                    try {
                        System.out.println("at release lock a");
                        alock.wait(1000);
                        System.out.println("at notified");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread bt = new Thread(() -> {
            try {
                Thread.sleep(10);
                synchronized (alock) {
                    System.out.println("bt get lock a");
                    //alock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        System.out.println("at state is " + at.getState());
        System.out.println("bt state is " + bt.getState());

        at.start();
        bt.start();
        System.out.println("at state is " + at.getState());
        System.out.println("bt state is " + bt.getState());

        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("at state is " + at.getState());
        System.out.println("bt state is " + bt.getState());
    }
}
