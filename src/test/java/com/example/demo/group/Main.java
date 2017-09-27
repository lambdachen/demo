package com.example.demo.group;

import java.util.*;

/**
 * Created by ChenLY on 2017-09-18.
 */
public class Main {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>(Arrays.asList(new User("jack"), new User("rose"), new User("jim")));
        System.out.println(groupByFirstChar(list));
    }

    public static Map<String, List<User>> groupByFirstChar(List<User> userList) {
        Map<String, List<User>> result = new HashMap<>();
        for (User user : userList) {
            String firstChar = user.getName().substring(0, 1);
            List<User> users;
            if (result.get(firstChar) == null) {
                users = new ArrayList<>();
                result.put(firstChar, users);
            } else {
                users = result.get(firstChar);
            }
            users.add(user);
        }
        return result;
    }

}
