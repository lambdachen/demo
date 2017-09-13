package com.example.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenLY on 2017-09-11.
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "b", "c"));
        List<String> lst = Arrays.asList("a", "b", "c");

        list.removeIf(item -> item.equals("b"));

        list.forEach(System.out::println);
        //list.stream().filter(t -> t.startsWith("a") || t.startsWith("b")).map(n -> n + "c").forEach(System.out::println);
    }
}
