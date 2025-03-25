package org.example.vthread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        var a = CompletableFuture.supplyAsync(() -> {
            System.out.println("Started call 1 ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Success call 1 ...");
            return 1;
        }).thenAccept(System.out::println);
        System.out.println("Main thread ...");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Started call 2 ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Success call 2 ...");
            return 1;
        }).thenAccept(System.out::println);
    }
}
