package org.example.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin1 {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool pool = new ForkJoinPool();
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(200);
        simpleRecursiveAction.invoke();
//        pool.submit(simpleRecursiveAction);
    }
}
