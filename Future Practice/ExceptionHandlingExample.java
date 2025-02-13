import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            if(true){
                throw new RuntimeException("Something went wrong.");
            }

            return "Success";
        }).exceptionally(ex->"Recovered from error: " + ex.getMessage());

        System.out.println(future.join());
        Thread.sleep(2000);

    }   
}
