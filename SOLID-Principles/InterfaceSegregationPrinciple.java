
interface Workable{
    void work();
}

interface Eatable{
    void eat();
}

interface Sleepable{
    void sleep();
}

class HumanWorker implements Workable, Eatable, Sleepable{

    public void work(){
        System.out.println("Human worker is working");
    }

    public void eat(){
        System.out.println("Human worker is eating");
    }

    public void sleep(){
        System.out.println("Human worker is sleeping");
    }

}


class RoboWorker implements Workable{

    public void work(){
        System.out.println("Robot is working");
    }
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        HumanWorker h1 = new HumanWorker();
        h1.eat();
        h1.work();
        h1.sleep();

        RoboWorker r1 = new RoboWorker();

        r1.work();
        
    }
}


/*

Interface Segregation Principle
A class should not be forced to implement interfaces it does not use.
 */