package com.qnym.service.test;

import org.junit.Test;

/**
 * Created by liuhaikuo on 2017/10/16.
 */
public class TestF {

    @Test
    public  void compare(){

        Long ss= 99L;
        Long s1 = 99L;
        Integer s4 = 99;
        Double d1 = 99.2;
        Double d3= 99.2;
        Double d2= 99.20;

        if(ss == s1){
            System.out.print(1111);
        }
        if(d1 == d3){
            System.out.print(22222);
        }
    }

}
