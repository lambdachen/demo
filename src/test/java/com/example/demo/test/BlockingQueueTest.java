package com.example.demo.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenliuyang on 2017-09-04.
 */
public class BlockingQueueTest {

    private class Apple {
        private int id;

        public Apple(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Apple" + this.id;
        }
    }

    private class Container {
        private BlockingQueue<Apple> queue = new ArrayBlockingQueue<>(5);

        public void add(Apple apple) throws InterruptedException {
            queue.put(apple);
        }

        public Apple get() throws InterruptedException {
            return queue.take();
        }

        public synchronized int size() {
            return queue.size();
        }

    }

    private class Consumer implements Runnable {

        private Container container;

        public Consumer(Container container) {
            this.container = container;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getId() + ",get->" + container.get() + ",size->" + container.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Provider implements Runnable {

        private Container container;

        private AtomicInteger num;

        public Provider(Container container, AtomicInteger num) {
            this.container = container;
            this.num = num;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    Apple apple = new Apple(num.incrementAndGet());
                    container.add(apple);
                    System.out.println(Thread.currentThread().getName() + ",add->" + apple);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueTest test = new BlockingQueueTest();
        Container container = test.new Container();
        AtomicInteger num = new AtomicInteger(0);
        Provider provider1 = test.new Provider(container, num);
        Provider provider2 = test.new Provider(container, num);
        Consumer consumer = test.new Consumer(container);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(provider1);
        executorService.submit(provider2);
        executorService.submit(consumer);
        Thread.sleep(3000);
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
    }

}
