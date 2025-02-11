import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CustomTime{
    int id;
    LocalTime starTime;
    LocalTime stopTime;
}

class Biker implements Callable<String>{
    
    CustomTime customTime = null;
    int bikerId;
    String name;

    Biker(int bikerId, String name, CustomTime customTimeObj){
        this.bikerId = bikerId;
        this.name = name;
        this.customTime = customTimeObj;
    }

    public String call(){
        customTime.id = this.bikerId;
        Random rand = new Random();
        customTime.starTime = LocalTime.now();

        System.out.println("Biker: " +bikerId + " is starting his race at " +customTime.starTime);

        for(int i = 0; i<100; i = i+rand.nextInt(10)+1){
            System.out.println(name + " is at " + i +"0m");
            try {
                Thread.sleep(rand.nextInt(100)+100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        customTime.stopTime = LocalTime.now();
        return "Biker" +name + " has completed the race at: " +customTime.stopTime;   
    }
}


public class BikeRacingWithCallableInterface {

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

    public static void main(String[] args) throws Exception {

        CustomTime[] results = new CustomTime[10];

        for(int i = 0; i<10; i++){
            results[i] = new CustomTime();
        }


        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> bikers = new ArrayList<>();

        for(int i = 0; i<10; i++){
            bikers.add(new Biker(i+1, String.valueOf((char) ('A' + i)), results[i]));
        }

        List<Future<String>> outputs = executor.invokeAll(bikers);

        for(Future<String> output: outputs){
            System.out.println(output.get());
        }

        executor.shutdown();
    }
    
}
