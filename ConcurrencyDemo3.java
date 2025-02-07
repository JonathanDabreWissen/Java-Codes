public class ConcurrencyDemo3 {
    public static void main(String[] args) {
        new IncThread("A");
        new IncThread("B");
        new IncThread("C");

    }
}

class Shared{
    static int count = 0;
}
class IncThread implements Runnable{
    String name;

    IncThread(String n){
        name = n;
        new Thread(this).start();
    }
    public void run(){
        try {
            System.out.println(name +" is waiting for permission");
            for(int i=0; i<5; i++){
                Shared.count++;
                System.out.println(name +": " +Shared.count);
                Thread.sleep(2000);
            }
            System.out.println(name +" released the permission");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class A extends Thread{
    
}

