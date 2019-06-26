package com.qnym.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeTest {



    public static void main(String[] args) {
        LocalDateTime ldt =  LocalDateTime.now();

        System.out.println(ldt);

        DateTimeFormatter dfm =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String ss  = ldt.format(dfm);
        System.out.println(ss);
    }
}
