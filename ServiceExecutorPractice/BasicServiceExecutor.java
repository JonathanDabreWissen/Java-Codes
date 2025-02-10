// package ServiceExecutorPractice;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{
    private int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    public void run(){
        System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);//Simulating work
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Work completed of Task: " +taskId);
    }
}

public class BasicServiceExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 1; i<= 5; i++){
            executor.execute(new Task(i));
        }

        executor.shutdown(); //Stop accepting new task
    }   
}
