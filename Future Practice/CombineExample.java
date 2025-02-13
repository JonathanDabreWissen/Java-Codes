import java.util.concurrent.CompletableFuture;

public class CombineExample {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->"Hello");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->"World");

        CompletableFuture<String> combined = future1.thenCombine(future2,(res1, res2)-> res1 + " " + res2);

        System.out.println("Final Result: " + combined.join());
    }   
}
