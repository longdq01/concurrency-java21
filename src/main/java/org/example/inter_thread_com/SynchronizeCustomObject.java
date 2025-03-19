package org.example.inter_thread_com;

public class SynchronizeCustomObject {

    private static int counter1 = 0;
    private static int counter2 = 0;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    incrementCounter1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    incrementCounter2();
                }
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void incrementCounter1(){
        synchronized (lock1){
            counter1++;
        }
    }

    private static void incrementCounter2(){
        synchronized (lock2){
            counter1++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        process();
        System.out.println(counter1);
        System.out.println(counter2);
    }
}
