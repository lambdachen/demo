package com.example.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    @Test
    public void test1() {
        List<String> alist = new ArrayList<>();
        alist.add("a");
        alist.add("b");
        alist.add("c");
        System.out.println(alist.get(2));

        List<String> llist = new LinkedList<>();
        llist.add("a");
        llist.add("b");
        llist.add("c");
        llist.add("c");
        llist.remove("c");
        String[] strArr = llist.toArray(new String[0]);
        System.out.println(Arrays.toString(strArr));
    }

    @Test
    public void test2() {
        System.out.println(2 << 3);
    }

    @Test
    public void test3() {
        System.out.println(Type.B.name());
    }

    enum Type {
        A("a", 0), B("b", 1), C("c", 2);

        private String alias;

        private int value;

        Type(String alias, int value) {
            this.alias = alias;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }


    }
}
