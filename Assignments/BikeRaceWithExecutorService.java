import java.time.LocalTime;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.*;

class CustomTime{
    int id;
    LocalTime startTime;
    LocalTime stopTime;
}

class Biker implements Runnable{

    static boolean allReady = false;
    static final Object lock = new Object();

    
    CustomTime customTime = null;
    int bikerId;
    String name;


    Biker(int bikerId, String name, CustomTime customTimeObj){
        this.bikerId = bikerId;
        this.name = name;
        this.customTime = customTimeObj;
    }

    public void run (){
        customTime.id = this.bikerId;
        Random rand = new Random();
        
        synchronized (lock) {
            while (!allReady) {
   
                try {
                    lock.wait();                
                } catch (Exception e) {
                    System.out.println(name +" interrupted while waiting to start the race.");
                }
            }
        } 

        
        
        customTime.startTime = LocalTime.now();
        

        for(int i = 0; i<100; i = i+ rand.nextInt(10) + 1){
            System.out.println(name + " is at " + i + "0m");
            try {
                Thread.sleep(rand.nextInt(100) + 100); // Random sleep time between 100ms to 200ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println( "Biker " + name + " has completed the race");
        customTime.stopTime = LocalTime.now();
    }

}

public class BikeRaceWithExecutorService {

    static{

        System.out.println("Bike Racing Game 1KM Track");
        System.out.println("-----------------");
        System.out.println("The countdown begins....");

        for(int i = 10; i>0; i--){
            System.out.print(i + " ");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }

        System.out.println("GO");
    }
    
    public static void main(String[] args) {
        CustomTime[] results = new CustomTime[10];

        // System.out.println(results[0]); // null

        for(int i = 0; i<10; i++){
            results[i] = new CustomTime();
        }
        
        // Biker b1 = new Biker(1, "A", results[0]);
        // Biker b2 = new Biker(2, "B", results[1]);
        // Biker b3 = new Biker(3, "C", results[2]);
        // Biker b4 = new Biker(4, "D", results[3]);
        // Biker b5 = new Biker(5, "E", results[4]);
        // Biker b6 = new Biker(6, "F", results[5]);
        // Biker b7 = new Biker(7, "G", results[6]);
        // Biker b8 = new Biker(8, "H", results[7]);
        // Biker b9 = new Biker(9, "I", results[8]);
        // Biker b10 = new Biker(10, "J", results[9]);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        System.out.println("Starting the race now....");
        // b1.start();
        // b2.start();
        // b3.start();
        // b4.start();
        // b5.start();
        // b6.start();
        // b7.start();
        // b8.start();
        // b9.start();
        // b10.start();

        for(int i =0; i<10; i++){
            executor.execute(new Biker(i+1, String.valueOf((char)('A' + i)), results[i]));
        }

        synchronized (Biker.lock) {
            Biker.allReady = true;
            Biker.lock.notifyAll();
        }
		

        try{
            // b1.join();
            // b2.join();
            // b3.join();
            // b4.join();
            // b5.join();
            // b6.join();
            // b7.join();
            // b8.join();
            // b9.join();
            // b10.join();

            if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdown();
            }
        }catch(InterruptedException e){ 
            System.out.println(e);
        }


        Arrays.sort(results, (a, b) -> a.stopTime.compareTo(b.stopTime));

        System.out.println();
        System.out.println("The results are as follows: ");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Biker " + results[i].id +" started at "+ results[i].startTime  +" finished at " + results[i].stopTime );
        }


    }
}

/*
Bike Racing Game
-----------------
* 10 Bikers with names and their start time
* Countdown 10, 9, 8, ...... GO
* Every biker when reaching the finish line mark their end time and ranking
* Display the bikers list in ascending order of their rankings 
* Display rankings along with start time, end time and time-taken

*/

/*
 For 10 bikers will create a thread class, 10 threads of that class.
 First in main class countdown 10 to 0. may be countdown starts 
 Start all threads



 inside, thread, initialize clock object
 */