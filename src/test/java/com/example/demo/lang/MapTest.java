package com.example.demo.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ChenLY on 2018/1/15.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> strList = new ArrayList<>();
        map.putIfAbsent("a", strList);
        System.out.println(map.computeIfPresent("a", (k, v) -> {
            System.out.println(v == strList);v.add(k); return v;}));
//        System.out.println(map.computeIfAbsent("b", k -> k + "bbbb"));
        System.out.println(map);
    }
}
