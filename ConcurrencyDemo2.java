import java.util.concurrent.*;


public class ConcurrencyDemo2 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        es.submit(new Greet());
        Future<Integer> f1 = es.submit(new Sum(5));
        Future<Integer> f2 = es.submit(new Sum(20));
        Future<Integer> f3 = es.submit(new Sum(100));
        System.out.println("Sum(5): " +f1.get());
        System.out.println("Sum(20): " +f2.get());
        System.out.println("Sum(100): " +f3.get());

        es.shutdown();

    }   
}


class Greet implements Runnable{
    public void run(){
        for(int i =1; i<=10; i++){
            System.out.println("From Greet : " +i);
        }
    }
}
class Sum implements Callable{

    int val;
    Sum(int val){
        this.val = val;
    }
    public Integer call(){
        int sum = 0;
        for(int i = 0; i<= val; i++){
            sum = sum + i;
        }

        return sum;
    }
}