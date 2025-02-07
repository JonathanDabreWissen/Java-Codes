import java.util.concurrent.*;
public class ConcurrencyDemo4 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            for(int i = 1; i<=10; i++){
                System.out.println("Using supplyAsync for String type: " +i);
            }

            return "Completed the execution";

        });

        CompletableFuture.runAsync(()->{
            for(int i = 1; i<=10; i++){
                System.out.println("Using runAsync: " +i);
            }

        });
        
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(()->{
            double res =0;
            for(int i =1; i<=10; i++){
                System.out.println("Using supplyAsync for the Double Type: " +i) ;
            }
            for(int j=1; j<=100; j++){
                res = res +j;
            }
            return res;
        });

        // Thread.sleep(1000);
        // System.out.println("Result: " +cf1.get());

        //f.join();

        cf2.thenApplyAsync((x)->{
            System.out.println("Summing till 100 is: " +x);
            return x;
        });
        
        System.out.println("Main Exit :) ");
        Thread.sleep(1000);

    }
}