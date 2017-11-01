package com.example.demo.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by ChenLY on 2017-10-16.
 */
public class CompareTest {

    @Test
    public void test1() throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(new Person("b", "a"));
        people.add(new Person("a", "c"));
        people.add(new Person("a", "b"));
        people.add(new Person("a", "a"));
        people.add(new Person("b", "b"));
        people.add(new Person("c", "a"));

        Comparator<Person> comparator = Comparator.comparing(Person::getFirstName);
        comparator = comparator.thenComparing(p -> p.getLastName()).reversed();

        people.sort(comparator);

//        people.stream().forEach(System.out::println);

        Consumer<Person> consumer = System.out::println;
//        consumer = consumer.andThen(System.out::println);

        people.stream().forEach(consumer);
    }
}
