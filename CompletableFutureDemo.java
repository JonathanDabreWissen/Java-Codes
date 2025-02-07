import java.util.concurrent.CompletableFuture;

import javax.management.RuntimeErrorException;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        /*
        
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
            return "Hello World!!";
        });

        String result ="Old value";
        try {
            
            result = future.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(result);
        */

        CompletableFuture.supplyAsync(()->{
            if(Math.random()>0.5){
                throw new RuntimeErrorException(null, "Something went wrong");
            }
            return "Task Successful";
        }).thenAccept(result->System.out.println("Result: " +result))
            .exceptionally(e -> {System.out.println("Error: " + e.getMessage());
                return null;
            });




    }
}
