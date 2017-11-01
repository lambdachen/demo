package com.example.demo.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by ChenLY on 2017-10-19.
 */
public class TimeTest {

    @Test
    public void test() throws Exception {
        Instant instant = new Date().toInstant();
        System.out.println(instant);

        Clock.systemDefaultZone().instant();
    }

    @Test
    public void test1() throws Exception {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = localTime.format(dateTimeFormatter);
        System.out.println(str);
    }
}
