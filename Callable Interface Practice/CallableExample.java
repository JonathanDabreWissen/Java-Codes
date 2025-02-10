// package Callable Interface Practice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask implements Callable<String>{
    private String name;

    public MyTask(String name){
        this.name = name;
    }

    public String call() throws Exception{
        Thread.sleep(2000);//Simulating work

        return "Task " + name + " Completed by " + Thread.currentThread().getName();
    }
}

class ErrorTask implements Callable<Integer>{
    public Integer call() throws Exception{
        Random r = new Random();
        int a = r.nextInt();
        if(a%2== 0){
            throw new Exception("Something went wrong!!");
        }
        return 1;
    }
}

public class CallableExample {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future1 = executor.submit(new MyTask("A"));
        Future<String> future2 = executor.submit(new MyTask("B"));

        System.out.println("Waiting for tasks to complete...");

        System.out.println(future1.get());
        System.out.println(future2.get());

        executor.shutdown();

        ExecutorService executor2 = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future3 = executor2.submit(new ErrorTask());
            System.out.println(future3.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            executor2.shutdown();
        }
        executor2.shutdown();
    }
}
