package com.qnym.business.thread;

import java.util.concurrent.*;

public class ExcutorTest {

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
    public static void main(String[] args) {
//        ThreadPoolExecutor
    }
}
