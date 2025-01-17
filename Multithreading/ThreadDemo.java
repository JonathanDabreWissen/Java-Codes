// package Multithreading;
class A extends Thread {

    public void run(){
        for(int i = 1; i<=20; i++){
            System.out.println("Anita: " + i);
        }
    }
}

class B extends Thread {

    public void run(){
        for(int i = 1; i<=20; i++){

            System.out.println("Babita: " +i);
            try{
                if(i%3 == 0){
                    Thread.sleep(3000);
                }
            
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

class C extends Thread {

    public void run(){
        for(int i = 1; i<=20; i++){
            System.out.println("Chaitra: " +i); 
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        A a1 = new A();
        B b1 = new B();
        C c1 = new C();

        a1.start();
        b1.start();
        c1.start();

        for(int i = 1; i<=20; i++){
            System.out.println("Main: " + i);
        }

        System.out.println("--------Main Exit ---------");
    }
}
