// package Future Practice;

import java.util.concurrent.*;

class LongTask implements Callable<String>{

    public String call() throws InterruptedException{
        Thread.sleep(5000);
        return "Long task finished";
    }
}

public class CancellingTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(new LongTask());

        Thread.sleep(2000);

        future.cancel(true);

        if(future.isCancelled()){
            System.out.println("Task was cancelled.");
        }

        executor.shutdown();

    }
}
