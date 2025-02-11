// package Future Practice;

import java.util.concurrent.*;


class MyTask implements Callable<String>{
    public String call() throws InterruptedException{
        Thread.sleep(2000);
        return "Task Completed";
    }
}

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit((new MyTask()));

        if(!future.isDone()){
            System.out.println("Task is still running...");
        }

        String result = future.get();
        System.out.println("Result: " +result);
        System.out.println("Main Thread completes");
        executor.shutdown();

    }
}
