package com.example.demo.wildcard;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenLY on 2017-11-02.
 */
public class WildcardTest {

    static class Human<T> {
    }

    static class Man<T> extends Human<T> {
    }

    static class Woman extends Human {

    }

    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();

        list.add(new Man());
        list.add(new Human());

        List<? super Human> lst = new ArrayList<>();
        lst.add(new Human());
        lst.add(new Man());
        lst.add(new Woman());
        lst.get(0);
    }

    @Test
    public void test() {
        Type type = Human.class.getGenericSuperclass();
        System.out.println(type);
    }
}
