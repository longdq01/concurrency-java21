package org.example.vthread;

import java.util.concurrent.StructuredTaskScope;

public class StructureConcurrency {

    public static void main(String[] args) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()){
            var process1 = new LongProcess(1, "result 1");
            var process2 = new LongProcess(3, "result 2");

            // we submit tasks in the parallel
            StructuredTaskScope.Subtask<String> res1 = scope.fork(process1);
            StructuredTaskScope.Subtask<String> res2 = scope.fork(process2);

            scope.join();
            scope.throwIfFailed();
            if(res1.state() == StructuredTaskScope.Subtask.State.SUCCESS)

            // combine the result
            System.out.println(res1.get() + "-" + res2.get()); // get will not block because join() waits thread to finish
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
