package com.example.demo.guava;

import org.junit.Test;

import java.io.File;

/**
 * Created by ChenLY on 2017-09-27.
 */
public class GuavaTest {

    public void test() throws Exception {
//        Files.asByteSource(new File("")).hash(Hashing.hmacMd5(Key));
    }

    @Test
    public void test1() throws Exception {
        File file = new File("pom.xml");
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
        } else {
            System.out.println("the file is not exist");
        }
    }

    @Test
    public void test2() throws Exception {
        String s = "a";
        switch (s) {
            case "a":
                System.out.println("a");
            case "b":
                System.out.println("b");
            case "c":
                System.out.println("c");
            default:
                System.out.println("none");
        }
    }

}
