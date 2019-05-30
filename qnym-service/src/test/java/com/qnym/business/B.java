package com.qnym.business;

public class B extends A{

    public B() {
        System.out.println("B的构造方法");
    }
    static {
        System.out.println("B的静态块");
    }
    private static String staticStr2 = getStaticStr2();

    private String str2 = getStr2();

    {
        System.out.println("B的实例块");
    }

    private static String getStaticStr2() {
        System.out.println("B的静态属性初始化");
        return null;
    }
    private String getStr2() {
        System.out.println("B的实例属性初始化");
        return null;
    }

    public static void main(String[] args) {
        System.out.println("bbbbbbb");
        new A();
        System.out.println("111111111");
        new B();
        System.out.println("22222222");
        new B();

    }
}
