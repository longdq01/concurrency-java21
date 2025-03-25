package org.example.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        // if the task is large, split it and execute in parallel
        if(simulatedWork > 100){
            System.out.println("Parallel execution and split the tasks...");

            SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulatedWork / 2);
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulatedWork / 2);

//            action1.fork();
//            action2.fork();
//
//            action1.join();
//            action2.join();
            invokeAll(action1, action2); // inserted tasks into pool
        }else{
            System.out.println("The task is smaller so sequential execution is fine...");
            System.out.println("The size of the task is: " + simulatedWork);
        }
    }
}
