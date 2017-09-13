package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chenliuyang on 2017-09-05.
 */
public class ProducerConsumer1 {
    public static void main(String[] args) {
        ProducerConsumer1 demo = new ProducerConsumer1();
        Basket basket = demo.new Basket();
        new Thread(demo.new Producer(basket)).start();
        new Thread(demo.new Consumer(basket)).start();
        new Thread(demo.new Consumer(basket)).start();
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
        private BlockingQueue<Product> queue = new ArrayBlockingQueue<>(2);

        public void put(Product product) throws Exception {
            queue.put(product);
        }

        public Product take() throws Exception {
            return queue.take();
        }
    }

    class Producer implements Runnable {

        private Basket basket;

        public Producer(Basket basket) {
            this.basket = basket;
        }

        @Override
        public void run() {
            for (int i = 0; i < 40; i++) {
                try {
                    Product product = new Product(i);
                    basket.put(product);
                    System.out.println(Thread.currentThread().getName()+"生产了" + product);
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
            for (int i = 0; i < 20; i++) {
                try {
                    Product product = basket.take();
                    System.out.println(Thread.currentThread().getName()+"消费了" + product);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

