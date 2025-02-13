import java.util.concurrent.CompletableFuture;

public class ChainingExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"Hello")
            .thenApply(result->result + " World")
            .thenApply(String::toUpperCase)
            .thenApply(result->result + " from my chaining attempt");
        
        System.out.println(future.get());
        future.join();
        // System.out.println("Final Result: " + future.join());
    }
}
