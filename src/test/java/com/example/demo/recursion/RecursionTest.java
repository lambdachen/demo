package com.example.demo.recursion;

import org.junit.Test;
import sun.security.provider.Sun;

/**
 * Created by ChenLY on 2017-09-07.
 */
public class RecursionTest {

    @Test
    public void test1() throws Exception {
        System.out.println(add(2));
        System.out.println(add(100));
        System.out.println(f(1));   //actually is 1
        System.out.println(f(2));   //actually is 2
        System.out.println(f(5));   //actually is 120
        System.out.println(adds(1));
        System.out.println(adds(2));
        System.out.println(adds(3));
    }


    public int add(int n) {
        if (n == 1) {
            return 1;
        }
        return n + add(n - 1);
    }

    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public int adds(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += f(i);
        }
        return sum;
    }
}
