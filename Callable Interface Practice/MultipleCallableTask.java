// package Callable Interface Practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class NumberTask implements Callable<Integer>{
    private int number;
    
    public NumberTask(int number){
        this.number = number;
    }

    public Integer call(){
        return number*number;
    }
}


public class MultipleCallableTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService   executor = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = Arrays.asList(
            new NumberTask(2),
            new NumberTask(3),
            new NumberTask(4)
        );
        
        List<Future<Integer>> results = executor.invokeAll(tasks);
        
        for(Future<Integer> result: results){
            System.out.println("Result: " +result.get());
        }

        executor.shutdown();

    }
}
