// package Future Practice;

import java.util.concurrent.*;


class MyTask implements Callable<String>{
    public String call() throws InterruptedException{
        Thread.sleep(3000);
        return "Task Completed";
    }
}

public class HandlingTimeout {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit((new MyTask()));

        if(!future.isDone()){
            System.out.println("Task is still running...");
        }

        String result ="No output yet";
        
        try{
            result = future.get(1, TimeUnit.SECONDS);
        }
        catch(TimeoutException e){
            System.out.println("Task took too long to complete!!");
        }
        System.out.println("Result: " +result);
        System.out.println("Main Thread completes");
        executor.shutdown();

    }
}
