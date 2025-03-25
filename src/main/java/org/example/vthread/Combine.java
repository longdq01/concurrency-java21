package org.example.vthread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Combine {
    public static void main(String[] args) {
        // run db query on thread and rest query on another thread
//        try(var service = Executors.newVirtualThreadPerTaskExecutor()){
//            CompletableFuture
//                    .supplyAsync(DBQuery::run, service)
//                    .thenCombine(CompletableFuture.supplyAsync(RestQuery::run, service),
//                            (res1, res2) -> {
//                                    return res1 + res2;
//                            })
//                    .thenAccept(System.out::println);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
