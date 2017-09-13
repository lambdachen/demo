package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenliuyang on 2017-09-05.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Basket basket = new Basket();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Producer(basket, "producer1"));
        executorService.submit(new Producer(basket, "producer2"));
        executorService.submit(new Consumer(basket));
//        new Thread(new Producer(basket)).start();
//        new Thread(new Consumer(basket)).start();

//        executorService.shutdown();
    }
}


class Product {
    private int id;

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product" + this.id;
    }
}

class Basket {
    private Product[] array = new Product[2];
    private int index = 0;

    public synchronized void put(Product product) throws Exception {
        while (index == array.length) {
            this.wait();
        }
        this.notifyAll();
        array[index] = product;
        index++;
    }

    public synchronized Product take() throws Exception {
        while (index == 0) {
            this.wait();
        }
        this.notifyAll();
        index--;
        return array[index];
    }
}

class Producer implements Runnable {

    private Basket basket;

    private String name;

    public Producer(Basket basket, String name) {
        this.basket = basket;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Product product = new Product(i);
                basket.put(product);
                System.out.println(Thread.currentThread().getName() + ","+name+"生产了" + product);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private Basket basket;

    public Consumer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            try {
                Product product = basket.take();
                System.out.println(Thread.currentThread().getName() + "消费了" + product);
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}