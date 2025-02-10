// package ServiceExecutorPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallTask implements Callable<String>{
    private int taskId;

    public CallTask(int taskId){
        this.taskId = taskId;
    }

    public String call() throws Exception{
        System.out.println("Working on task: " +taskId);
        Thread.sleep(2000);
        return "Task " + taskId +" completed by " + Thread.currentThread().getName();
    }
}

public class CallableTask {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future1 = executor.submit(new CallTask(1));
        Future<String> future2 = executor.submit(new CallTask(2));

        System.out.println("Waiting for the tasks to complete");

        System.out.println(future1.get());
        System.out.println(future2.get());

        executor.shutdown();
    }   
}
