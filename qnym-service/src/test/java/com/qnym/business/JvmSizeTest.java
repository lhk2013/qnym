package com.qnym.business;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class JvmSizeTest {

    @Test
    public void  testSize(){

//        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
//        System.out.println(ClassLayout.parseClass(Fruit.class).toPrintable());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
        System.out.println(ClassLayout.parseClass(B.class).toPrintable());
        System.out.println(ClassLayout.parseClass(SignInfo.class).toPrintable());
        B b = new B();
        System.out.println(b);

    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            newApple();
        }
        System.out.println("take time:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void newApple() {
        new Apple();
    }
}
