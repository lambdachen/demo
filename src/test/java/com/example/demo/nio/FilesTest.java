package com.example.demo.nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by ChenLY on 2018/1/16.
 */
public class FilesTest {

    @Test
    public void test() throws Exception {
        Path path = Paths.get("C:\\Users\\chenliuyang.thomas\\Desktop\\龙之谷任务步骤.txt");
        System.out.println(path.getRoot());
        if (Files.exists(path) && !Files.isDirectory(path)) {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                System.out.println(readLine);
            }
        }
    }

    @Test
    public void test1() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\chenliuyang.thomas\\Desktop\\龙之谷任务步骤.txt"));
        Files.copy(fileInputStream, Paths.get("d:/1.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void test2() throws Exception {
        Files.copy(Paths.get("d:/1.txt"), System.out);
    }
}
