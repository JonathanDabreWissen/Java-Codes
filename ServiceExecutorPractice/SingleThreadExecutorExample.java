// package ServiceExecutorPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <=5; i++) {
            executor.execute(()->{
                System.out.println("Task running on " +Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println("Task done on " +Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
