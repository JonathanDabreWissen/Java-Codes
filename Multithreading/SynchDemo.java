// package Multithreading;

class A implements Runnable{

    public void run(){
        System.out.println(Thread.currentThread().getName() +" is waiting for permission");

        synchronized(this){


            for(int i=1; i<=20; i++){
                System.out.println(Thread.currentThread().getName() +": " + i);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
}

public class SynchDemo {
    public static void main(String[] args) {
        A a1 = new A();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
        Thread t3 = new Thread(a1);

        t1.setName("Akash");
        t2.setName("Daemon");
        t3.setName("Prakash");

        t2.setDaemon(true);
        
        // a1.run();
        t1.start();
        t2.start();
        t3.start();

        // t2.setDaemon(false);
    }
}
