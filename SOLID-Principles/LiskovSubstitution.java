abstract class Bird{
    public abstract void eat();
}

interface Flyable{
    void fly();
}

class Sparrow extends Bird implements Flyable{
    public void eat(){
        System.out.println("Sparrow is eating");
    }

    public void fly(){
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    public void eat(){
        System.out.println("Penguin is eating");
    }
}

public class LiskovSubstitution {
    
    public static void main(String[] args) {
        Sparrow s1 = new Sparrow();
        s1.eat();
        s1.fly();

        Penguin p1 = new Penguin();
        p1.eat();
    }
}

// 
/*
 Liskov Substitution Principle (LSP)
 Objects of a superclass should be replaceable with objects of its subclass without affecting the correctness of the program.

 A simple example involving Birds. Some birds can fly, while others cannot. If we treat all birds as if they can fly, we might break the program when dealing with birds that cannot fly.
 */