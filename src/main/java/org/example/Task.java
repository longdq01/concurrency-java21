package org.example;

public class Task implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Run");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
