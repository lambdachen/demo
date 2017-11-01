package com.example.demo.lang;

/**
 * Created by ChenLY on 2017-10-30.
 */
public class Outter {

    private int a = 1;

    private int b = 2;

    private Inner getInner() {
        return new Inner();
    }

    public int getInnerA() {
        return new Inner().a;
    }

    public class Inner {

        private int a = 11;

        private int b = 22;

        public void print() {
            System.out.println("the outter class a is " + Outter.this.a);
            System.out.println("the outter class b is " + b);
        }

        public Outter getOutterInstance() {
            return Outter.this;
        }
    }
}
