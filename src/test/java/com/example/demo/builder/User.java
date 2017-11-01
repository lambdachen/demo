package com.example.demo.builder;

/**
 * Created by ChenLY on 2017-10-31.
 */
public class User {

    private String name;

    private String address;

    private User(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "username[" + this.name + "], address[" + this.address + "]";
    }

    public static class Builder {

        private String name;

        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.Builder().name("jack").address("china").build();
        System.out.println(user);
    }
}

