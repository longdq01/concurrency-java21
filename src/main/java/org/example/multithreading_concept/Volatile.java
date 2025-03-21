package org.example.multithreading_concept;

class Worker implements Runnable{
    // volatile make this variable will be stored in main memory
    private boolean isTerminated = false;

    @Override
    public void run() {
        while(!isTerminated){
            System.out.println("Worker is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}

public class Volatile {

    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();

        Thread t1 = new Thread(w);
        t1.start();
        Thread.sleep(3000);
        w.setTerminated(true);
        System.out.println("Algorithm is terminated");
    }
}
