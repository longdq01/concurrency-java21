package org.example.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Ex1Main {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Ex1 action = new Ex1(List.of(1,2,3,4,5));
        pool.invoke(action);
    }
}
