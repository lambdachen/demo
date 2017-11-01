package com.example.demo.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenLY on 2017-10-19.
 */
public class OutOfMemoryMock {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int index = 0;
        boolean flag = true;
        while (flag) {
            try {
                index++;
                list.add(new byte[1024 * 1024]);
            } catch (Error e) {
                e.printStackTrace();
                System.out.println(index);
                flag = false;
            }
        }
    }
}
