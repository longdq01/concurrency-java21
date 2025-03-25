package org.example.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
//        int res = pool.invoke(new SimpleRecursiveTask(102));
//        System.out.println(res);

        System.out.println(pool.invoke(new FiboRecursiveTask(7)));
    }
}
