package org.example.forkjoin;

import java.util.concurrent.RecursiveTask;

public class FiboRecursiveTask extends RecursiveTask<Long> {

    private int n;

    public FiboRecursiveTask(int n) {
        this.n = n;
    }


    @Override
    protected Long compute() {
        if(n == 0 || n == 1)
            return (long) n;

        FiboRecursiveTask subTask1 = new FiboRecursiveTask(n - 1);
        FiboRecursiveTask subTask2 = new FiboRecursiveTask(n - 2);

        subTask1.fork();
        subTask2.fork();
        return subTask1.join() + subTask2.join();
    }
}
