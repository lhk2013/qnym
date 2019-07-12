package com.qnym.business.thread;

import javafx.concurrent.Task;

import java.util.concurrent.*;

public class ExcutorTest {


    public static class TheadA implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "thead A";
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TheadA{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class TheadB implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "thead B";
        }
    }

//    public static ExecutorService newSingleThreadExecutor() {
//        return new FinalizableDelegatedExecutorServic (
//                new ThreadPoolExecutor(1, 1,
//                        0L, TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>()));
//    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0,Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }
    public static void main(String[] args) throws Exception{
//        ThreadPoolExecutor
//
//        Task<String> task = new Task<String>() {
//            @Override
//            protected String call() throws Exception {
//                return "fuck";
//            }
//        };

//        String ss = task.get(5,TimeUnit.SECONDS);
//        System.out.println(ss);

        class Inner implements IA {
            private int index;
            @Override
            public void fun() {
                System.out.println("局部内部类的实例方法被调用,访问类中实例属性 index=" + index);
            }
            public Inner(int index) {
                this.index = index;
            }
        }
        Inner inner = new Inner(100);
    }


}
interface IA {
    //接口中必须有你要从外界调用的方法；
    void fun();
}
class ExcutorTest2 {

}