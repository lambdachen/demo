package com.example.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenLY on 2017-10-18.
 */
public class StreamTest {

    @Test
    public void test() throws Exception {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        final List<Integer> list2 = new ArrayList<>();
        list.stream().peek(item -> System.out.println("accept: " + item)).forEach(item -> list2.add(item));
        System.out.println(list2);
    }
}
