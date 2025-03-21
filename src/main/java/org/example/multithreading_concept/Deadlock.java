package org.example.multithreading_concept;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        Thread t1 = new Thread(deadlock::worker1);
        Thread t2 = new Thread(deadlock::worker2);

        t1.start();
        t2.start();
    }

    public void worker1(){
        lock1.lock();
        System.out.println("Worker 1 acquire lock 1");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("Worker 1 acquire lock 2");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        lock2.lock();
        System.out.println("Worker 2 acquire lock 2");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.lock();
        System.out.println("Worker 2 acquire lock 1");
        lock2.unlock();
        lock1.unlock();
    }
}
