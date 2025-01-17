// package Multithreading;



class MyObject{
    int goods = 0;
}

class Producer extends Thread{
    MyObject obj = null;

    Producer(MyObject obj){
        this.obj = obj;
    }

    public void run(){
        while(true){
            if(obj.goods <20){
                obj.goods++;
                System.out.println("Producer Produced: " + obj.goods);
            }
            else{
                try{
                    System.out.println("Producer is waiting");
                    sleep(3000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
}

class Consumer extends Thread{
    MyObject obj = null;

    Consumer(MyObject obj){
        this.obj = obj;
    }

    public void run(){
        while(true){
            if(obj.goods>0){
                obj.goods--;
                System.out.println("Consumer Consumed: " + obj.goods);
            }
            else{
                try{
                    System.out.println("Consumer is waiting");
                    sleep(3000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }

        }
    }
}


public class ProducerConsumerExample {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);

        p.start();
        c.start();
    }
}
