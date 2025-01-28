interface Vehicle{

    void drive();
}

class Car implements Vehicle{
    public void drive(){
        System.out.println("Car is running...");
    }
}

class Bike implements Vehicle{
    public void drive(){
        System.out.println("Bike is running...");
    }
}

class VehicleFactory{

    public Vehicle getVehicle(String type){

        if("Car".equalsIgnoreCase(type)){
            return new Car();
        }
        else if("Bike".equalsIgnoreCase(type)){
            return new Bike();
        }
        return null;
    }
}



public class Factory {
    public static void main(String[] args) {
        
        VehicleFactory vf = new VehicleFactory();

        Vehicle c1 = vf.getVehicle("car");
        c1.drive();

        Vehicle b1 = vf.getVehicle("Bike");
        b1.drive();

    }
}
