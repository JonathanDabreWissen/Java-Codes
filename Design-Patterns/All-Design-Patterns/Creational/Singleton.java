//package Design-Patterns.All-Design-Patterns.Creational;


//Basic Singleton implementation
class BasicSingleton{

    private static BasicSingleton instance;

    private BasicSingleton(){

    }

    public static BasicSingleton getBasicSingletonInstance(){
        if(instance == null){
            System.out.println("New instance created...");
            instance = new BasicSingleton();
        }
       
        return instance;
        
    }

    public void displayBasicSingleton(){

        System.out.println("Hello, basic singleton here.");
    }


}
public class Singleton {
    public static void main(String[] args) {
        BasicSingleton b1 = BasicSingleton.getBasicSingletonInstance();
        BasicSingleton b2 = BasicSingleton.getBasicSingletonInstance();

        System.out.println(b1);
        System.out.println(b2);



    }
    
}
