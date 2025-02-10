import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner implements Runnable{
    static boolean allReady = false;
    static final Object lock = new Object();
    String name;

    Runner(String name){
        this.name = name;
    }

    public void run(){
        synchronized(lock){
            //if(!allReady){ // only checks once
            while(! allReady){
                try {
                    System.out.println(name +" is waiting ...");
                    lock.wait();
                } catch (Exception e) {
                    System.out.println(name +" was interrupted. ");
                }
            }
        }
        System.out.println(name + " started running!");
    }
}

public class IfVsWhile {
    public static void main(String[] args) throws InterruptedException{
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
    
        executor.execute(new Runner("Runner A"));
        executor.execute(new Runner("Runner B"));
        executor.execute(new Runner("Runner C"));

        Thread.sleep(100);

        synchronized (Runner.lock) {
            System.out.println("Manually waking up ONE runner...");
            Runner.lock.notify(); // Wake up ONE runner before race starts
        }

        Thread.sleep(1000);

        synchronized(Runner.lock){
            System.out.println("Race starter says: Go!");
            Runner.allReady = true;
            Runner.lock.notifyAll();
        }

        executor.shutdown();
    }
}
