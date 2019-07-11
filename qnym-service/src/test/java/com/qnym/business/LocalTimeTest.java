package com.qnym.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeTest {



    public static void main(String[] args) throws Exception {
        LocalDateTime ldt =  LocalDateTime.now();

        System.out.println(ldt);

        DateTimeFormatter dfm =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String ss  = ldt.format(dfm);
        System.out.println(ss);

        while (true){
            String s =HttpClientUtil.doGet("http://10.6.21.116/robot/say?q=\\304\\343&user_id=333");
            System.out.println(s);
            break;
//            Thread.sleep(10000);
        }


    }
}
