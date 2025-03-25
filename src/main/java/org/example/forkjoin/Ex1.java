package org.example.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Ex1 extends RecursiveAction {

    private List<Integer> list;

    public Ex1(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected void compute() {
        if(list.size() >= 2){
            Ex1 task1 = new Ex1(list.subList(list.size() - 1, list.size()));
            Ex1 task2 = new Ex1(list.subList(0, list.size() - 1));
            invokeAll(task1, task2);
        }else{
            System.out.println(list);
        }
    }
}
