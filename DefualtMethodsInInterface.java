interface Vehicle{

    public void start();

    public default void  honk(){
        System.out.println("Honking....");
    }
}

class Car implements Vehicle{
    public void start(){
        System.out.println("Starting car");
    }
}

class Bike implements Vehicle{
    public void start(){
        System.out.println("Starting Bike");
    }
    public void honk(){
        System.out.println("Peep peep....");
    }
}

public class DefualtMethodsInInterface {
    public static void main(String[] args) {
        Vehicle v1 = new Car();

        Vehicle v2 = new Bike();

        v1.start();
        v1.honk();

        v2.start();
        v2.honk();
    }
}
