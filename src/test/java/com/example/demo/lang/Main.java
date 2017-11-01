package com.example.demo.lang;

import org.junit.Test;

import java.net.URL;
import java.text.MessageFormat;
import java.util.*;
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

    @Test
    public void test() throws Exception {

    }

    @Test
    public void test1() throws Exception {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b"));
        String[] array = list.toArray(new String[5]);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() throws Exception {
        String a = "abc";
        String b = "abc";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    @Test
    public void test3() throws Exception {
        final StringBuilder sb = new StringBuilder();
        sb.append("aaa");
        System.out.println(sb);
    }

    @Test
    public void test4() throws Exception {

        String urlStr = "http://cdn.com/a/b/";
        URL url = new URL(urlStr);
        System.out.println(url.getHost());

        String host = url.getHost();

        String newDomainName = "abc.com";
        System.out.println(urlStr.replaceFirst(host, newDomainName));

    }

    @Test
    public void test5() {
        String pattern = "{0},{1},{2}" + System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format(pattern, "a", "b", "c"));
        sb.append(MessageFormat.format(pattern, "a", "b", "c"));
        sb.append(MessageFormat.format(pattern, "a", "b", "c"));
        System.out.println(sb.toString());
    }


    volatile String[] arr = new String[]{"a", "b"};

    @Test
    public void test6() {
        double a = 11.11;
        float b = 12.11f;
        System.out.println(a);
        System.out.println(b);
    }
}
