package com.qnym.business;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @Test
    public void  testSize2()throws Exception{

//        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
//        System.out.println(ClassLayout.parseClass(Fruit.class).toPrintable());
        System.out.println(ClassLayout.parseClass(WechartFriend.class).toPrintable());
        List<WechartFriend> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            WechartFriend f = new WechartFriend();
            list.add(f);
            f.setNickName(f.hashCode()+"");
//            Thread.sleep(1L);
            System.out.println("当前:"+i);
            if(i==50000){
                System.out.println(50000);
            }
        }
        System.out.println(11111);

        Set<String> os = new HashSet<>();

        os.add("1");
        os.add("2");
        os.add("3");
        os.add("4");
        os.add("5");
        os.add("6");

        Set<String> ns = new HashSet<>();
        ns.add("2");
        ns.add("3");
        ns.add("4");
        ns.add("5");
        ns.add("7");
        ns.add("9");
        ns.add("10");


        ns.retainAll(os);

        System.out.println("12334".matches("\\d+"));
    }

}
