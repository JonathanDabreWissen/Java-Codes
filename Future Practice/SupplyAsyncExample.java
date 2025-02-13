import java.util.concurrent.CompletableFuture;

public class SupplyAsyncExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }

            return "Hello form CompletableFuture!";
        });


        System.out.println("Doing other work");

        // future.join();
        future.thenAccept(result->System.out.println("Result:" +result));

    }
}
