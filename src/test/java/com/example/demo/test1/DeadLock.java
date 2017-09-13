package com.example.demo.test1;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class DeadLock {

    public static void main(String[] args) {

        final Object lock1 = new Object();

        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("the thread t1 get lock1");
                try {
                    Thread.sleep(1000);
                    lock1.wait(1000);
                    synchronized (lock2) {
                        System.out.println("the thread t1 get lock2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("the thread t2 get lock2");
                try {
                    Thread.sleep(1000);
                    synchronized (lock1) {
                        System.out.println("the thread t2 get lock1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("the thread t1[" + t1.getName() +  "] is " + t1.getState());
        System.out.println("the thread t2[" + t2.getName() +  "] is " + t2.getState());
        System.out.println("the main thread is terminated");
    }
}
