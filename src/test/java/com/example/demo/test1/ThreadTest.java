package com.example.demo.test1;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class ThreadTest {

    static boolean isRun = true;

    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("the t1 thread begins executing");
            while (isRun) {

                System.out.println("the theard[" + Thread.currentThread().getName() + "] is " + Thread.currentThread().getState());
                try {
                    synchronized (lock) {
                        lock.wait(10000);
                    }
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the t1 execution is over");
        });

        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("set the variable isRun to false");
        isRun = false;
        System.out.println("the theard[" + t1.getName() + "] is " + t1.getState());
        System.out.println("the theard[" + Thread.currentThread().getName() + "] is " + Thread.currentThread().getState());

    }
}
