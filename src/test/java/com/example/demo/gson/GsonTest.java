package com.example.demo.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenLY on 2017-09-14.
 */
public class GsonTest {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Type type = new TypeToken<List<String>>(){}.getType();

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        String listStr = gson.toJson(list);
        System.out.println(listStr);
        List<String> lst = gson.fromJson(listStr, type);
        System.out.println(lst.toString());


        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    }
}
