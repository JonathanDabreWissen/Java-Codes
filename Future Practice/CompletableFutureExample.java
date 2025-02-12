import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Void>  future = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(2000);
                System.out.println("Task executed asynchronously");
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        System.out.println("Main thread is free!");
        future.join();
    }
}
