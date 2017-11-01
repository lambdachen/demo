package com.example.demo.lang;

/**
 * Created by ChenLY on 2017-10-20.
 */
public class MemoryTest {

    public static void main(String[] args) {
        Demo demo = new Demo(1);
        int data = 1;
        MemoryTest test = new MemoryTest();
        System.out.println(demo + ", hashcode is " + demo.hashCode());
        test.change(demo);
        System.out.println(demo + ", hashcode is " + demo.hashCode());

        test.change(data);
        System.out.println("data is " + data);

    }

    public void change(Demo demo) {
        demo.setValue(2);
    }

    public void change(int data) {
        data = 2;
    }
}


class Demo {
    private int value;

    public Demo(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "the value of demo is " + this.value;
    }
}