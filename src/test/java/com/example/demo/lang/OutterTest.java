package com.example.demo.lang;

import com.example.demo.lang.Outter.Inner;

/**
 * Created by ChenLY on 2017-10-30.
 */
public class OutterTest {

    public static void main(String[] args) {
        Outter outter = new Outter();
//        Inner inner = outter.getInner();
        Inner inner = outter.new Inner();
        inner.print();

        System.out.println(outter == inner.getOutterInstance());
    }
}
