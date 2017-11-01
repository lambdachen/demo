package com.example.demo.lang;

/**
 * Created by ChenLY on 2017-10-31.
 */
public class OutterClass {

    static int a = 1;

    static class Inner {

        public void print() {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.print();
    }
}
