package org.example;

import java.util.concurrent.Executors;

public class VThread {

    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);  // Non-blocking with Virtual Threads
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Task executed by: " + Thread.currentThread());
                });
            }
        }
    }
}
