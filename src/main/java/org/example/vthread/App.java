package org.example.vthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws InterruptedException {
//        Thread.Builder builder = Thread.ofVirtual().name("virtual-", 0);
//        var t1 = builder.start(new VirtualTask());
//        var t2 = builder.start(new VirtualTask());
//
//        // all virtual thread are daemon thread
//        t1.join();
//        t2.join();

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(new VirtualTask());
            executor.submit(new VirtualTask());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
