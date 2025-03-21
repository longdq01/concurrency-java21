package org.example.multithreading_concept;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Livelock livelock = new Livelock();
        new Thread(livelock::worker1).start();
        new Thread(livelock::worker2).start();
    }

    private void worker1(){
        while(true){
            try{
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker 1 acquire lock 1");
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("Worker 1 try to acquire lock 2");
            if(lock2.tryLock()){
                System.out.println("Worker 1 acquire lock 2");
                lock2.unlock();
            }else{
                System.out.println("Worker 1 can't acquire lock 2");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    private void worker2(){
        while(true){
            try{
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker 2 acquire lock 2");
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("Worker 2 try to acquire lock 1");
            if(lock1.tryLock()){
                System.out.println("Worker 2 acquire lock 1");
                lock2.unlock();
            }else{
                System.out.println("Worker 2 can't acquire lock 1");
                continue;
            }
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }
}
