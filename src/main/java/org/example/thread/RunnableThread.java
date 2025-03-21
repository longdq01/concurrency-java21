package org.example.thread;

public class RunnableThread {
    static class Runner1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runner1 thread: " + i);
            }
        }
    }

    static class Runner2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runner2 thread: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        t1.start();
        t2.start();
    }
}
