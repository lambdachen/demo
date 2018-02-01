package com.example.demo.thread;

/**
 * Created by ChenLY on 2017-11-02.
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        final Thread t1 = new Thread(() -> {
            print("T1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("T2");
        });
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("the t2 state is " + t2.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        t1.start();
        t2.start();
    }

    private static void print(String threadName) {
        for(int i = 0; i < 3; i++) {
            System.out.println(threadName + ":" + i);
        }
    }
}
