package com.example.demo.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ChenLY on 2017-09-11.
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put(null, "aaa");
        map.put(null, "bbb");

        System.out.println(map.get(null));

        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(null, "aaa");
        System.out.println(concurrentMap.get(null));
    }
}
