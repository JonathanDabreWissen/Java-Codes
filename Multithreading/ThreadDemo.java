// package Multithreading;
class A extends Thread {

    public void run(){
        for(int i = 1; i<=20; i++){
            System.out.println(this.getName() + i);
        }
    }
}

class B extends Thread {

    public void run(){
        for(int i = 1; i<=20; i++){

            System.out.println(this.getName() +i);
            /* 
            try{
                if(i%3 == 0){
                    Thread.sleep(3000);
                    
                }
            
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
            */
        }
    }
}

class C extends Thread {

    public void run(){
        for(int i = 1; i<=20; i++){
            System.out.println(this.getName() +i); 
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("Demo");
        Thread a1 = new Thread(tg, new A());
        Thread b1 = new Thread(tg, new B());
        Thread c1 = new Thread(tg, new C());
        

        a1.setName("Rita");
        b1.setName("Geeta");
        c1.setName("Sita");

        a1.start();
        b1.start();
        c1.start(); 

        for(int i = 1; i<=20; i++){
            System.out.println("************Main: " + i +"************");
            if(i==5){
                tg.suspend();
            }
            if(i==8){
                System.out.println(" a1 is alive: " + a1.isAlive());
                System.out.println(" b1 is alive: " + b1.isAlive());
                System.out.println(" c1 is alive: " + c1.isAlive());
            }
            if (i==10) {
                tg.resume();   
            }
            if(i==15){
                tg.stop();
            }
        }

        try{
            a1.join();
            b1.join();
            c1.join();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        System.out.println("--------Main Exit ---------");
    }
}
