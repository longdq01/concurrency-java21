package org.example.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(4);

        executors.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Worker 1 is running");
            }
        });

        executors.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Worker 2 is running");
            }
            return 1;
        });
//        System.out.println(a.get());

    }
}
