package org.example.inter_thread_com;

public class SynchronizeKey {
    private static int counter = 0;

    public static Thread process(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    incrementCounter();
                }
            }
        });
        t.start();
        return t;
    }

    private static synchronized void incrementCounter(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = process();
        Thread t2 = process();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
