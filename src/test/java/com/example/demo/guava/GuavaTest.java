package com.example.demo.guava;

import org.junit.Test;
import org.springframework.util.DigestUtils;

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
    }
}
