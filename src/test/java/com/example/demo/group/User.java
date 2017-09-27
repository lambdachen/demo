package com.example.demo.group;

/**
 * Created by ChenLY on 2017-09-18.
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
