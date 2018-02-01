package com.example.demo.thread1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenLY on 2017-11-02.
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Print print = new Print();
        executorService.submit(() -> {
            try {
                print.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                print.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }

    private static class Print {

        int count = 0;

        public synchronized void printEven() throws InterruptedException {
            while (count < 2) {
                while (count % 2 == 1) {
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName() + " -> " + count++);
                this.notify();
            }
        }

        public synchronized void printOdd() throws InterruptedException {
            while (count < 2) {
                while (count % 2 == 0) {
                    this.wait();
                }
                System.out.println(Thread.currentThread().getName() + " -> " + count++);
                this.notify();
            }
        }
    }
}
