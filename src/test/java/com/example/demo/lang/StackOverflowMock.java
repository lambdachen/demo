package com.example.demo.lang;

/**
 * Created by ChenLY on 2017-10-19.
 */
public class StackOverflowMock {

    private int index;

    private void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackOverflowMock mock = new StackOverflowMock();
        try {
            mock.call();
        } catch (Error e) {
            System.out.println(mock.index);
        }
     }
}
