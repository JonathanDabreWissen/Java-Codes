
interface Tyres{
    void rotate();
}

interface PowerUnit{
    void accelerate(); // but it is voilation isp
}

interface Brakes{
    void decelerate();
}

class CeatTyres implements Tyres{
    public void rotate(){
        System.out.println("Ceat Tyres rotating...");
    }
}

class MRFTyres implements Tyres{
    public void rotate(){
        System.out.println("MRF Tyres rotating...");
    }
}

class ToyotaEngine implements PowerUnit{
    public  void accelerate(){
        System.out.println("Toyota Engine igniting...");
    }
}

class FordEngine implements PowerUnit{
    public void accelerate(){
        System.out.println("Ford Engine igniting...");
    }
}

class TeslaMotor implements PowerUnit{
    public void accelerate(){
        System.out.println("Tesla motor starting ...");
    }
}

class DiscBrake implements Brakes{
    public void decelerate(){
        System.out.println("Applying disc brakes....");
    }
}

class ConventionalBrake implements Brakes{
    public void decelerate(){
        System.out.println("Applying conventional brakes...");
    }
}

class Car{
    private PowerUnit powerUnit;
    private Tyres tyres;
    private Brakes brakes;

    public Car(PowerUnit powerUnit, Tyres tyres, Brakes brakes){
        this.powerUnit = powerUnit;
        this.tyres = tyres;
        this.brakes = brakes;
    }

    public void run(){
        powerUnit.accelerate();
        tyres.rotate();
        brakes.decelerate();
    }
}



public class DependencyInversionCarExample {

    public static void main(String[] args) {
        Car  mercedesMaybagh = new Car(new ToyotaEngine(), new CeatTyres(), new DiscBrake());
        mercedesMaybagh.run();

        Car bmwXI3 = new Car(new TeslaMotor(), new CeatTyres(), new DiscBrake());
        bmwXI3.run();
    }
}
