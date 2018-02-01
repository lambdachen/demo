package com.example.demo.thread1;

/**
 * Created by ChenLY on 2017-11-02.
 */
public class ThreadTest {

    public static void main(String[] args) {
        PrintTask task = new PrintTask();
        new Thread(() -> task.printA()).start();
        new Thread(() -> task.printB()).start();
    }

    private static class PrintTask {

        boolean isPrintB = true;

        public synchronized void printA() {
            for(int i = 0; i < 10; i++) {
                while (isPrintB) {
                    try {
                        this.wait();
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.notify();
                System.out.println(Thread.currentThread().getName() + " -> A");
                isPrintB = true;
            }
        }

        public synchronized void printB() {
            for(int i = 0; i < 10; i++) {
                while (!isPrintB) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.notify();
                System.out.println(Thread.currentThread().getName() + " -> B");
                isPrintB = false;
            }
        }
    }
}
