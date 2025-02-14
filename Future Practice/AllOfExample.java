import java.util.concurrent.CompletableFuture;

public class AllOfExample {
    public static void main(String[] args) throws Exception {
        
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(()->{
            try{
                Thread.sleep(1000);
                System.out.println("Task one completed");
            }catch(Exception e){
                System.out.println(e);
            }
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(2000);
                System.out.println("Task Two completed");
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(3000);
                System.out.println("Task three completed");
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        
        allFutures.join();

        System.out.println("All tasks completed!");
    }
}
