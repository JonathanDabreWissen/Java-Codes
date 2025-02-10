// package ServiceExecutorPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownExample {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 1; i<=3; i++){
            executor.execute(()->{
                System.out.println("Task running on" +Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println("Task done on " +Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        try {
            if(!executor.awaitTermination(3, TimeUnit.SECONDS)){
                System.out.println("Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (Exception e) {
            executor.shutdownNow();
        }
    }
}
