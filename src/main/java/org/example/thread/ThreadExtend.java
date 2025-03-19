package org.example.thread;

public class ThreadExtend {
    static class Runner1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runner1 thread: " + i);
            }
        }
    }

    static class Runner2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runner2 thread: " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Finished execution...");
    }
}
