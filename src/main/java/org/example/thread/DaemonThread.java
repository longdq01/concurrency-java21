package org.example.thread;

public class DaemonThread {
    static class Runner1 implements Runnable {
        @Override
        public void run() {
            while(true){
                try{
                    System.out.println("Daemon thread is running");
                    Thread.sleep(1000);
                }catch (Exception ex){
                    System.out.println("Error while running runner1");
                }
            }
        }
    }

    static class Runner2 implements Runnable {
        @Override
        public void run() {
            try{
                Thread.sleep(3000);
            }catch (Exception ex){
                System.out.println("Error while running runner2");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        t1.setDaemon(true);
        Thread t2 = new Thread(new Runner2());
        t1.start();
        t2.start();
    }
}
