package org.example.inter_thread_com;

public class SynchronizeIntrinsicLock {

    private static int counter1 = 0;
    private static int counter2 = 0;

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

    private static synchronized void incrementCounter1(){
        counter1++;
    }

    private static synchronized void incrementCounter2(){
        counter2++;
    }

    public static void main(String[] args) throws InterruptedException {
        process();
        System.out.println(counter1);
        System.out.println(counter2);
    }
}
