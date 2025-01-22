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

class ThreadSafeSingleton{

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){

    }

    // Making this get function synchronized, we ensure that only one thread can call this function.
    public static synchronized ThreadSafeSingleton getThreadSafeSingletonInstance(){

        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

class DoubleCheckedSingleton{

    private static volatile DoubleCheckedSingleton instance; //volatile keyword ensures that the instance is not cached in the thread.

    private DoubleCheckedSingleton(){

    }

    public static DoubleCheckedSingleton getDoubleCheckedSingletonInstance(){

        if(instance == null){
            synchronized(DoubleCheckedSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    } 
}
public class Singleton {
    public static void main(String[] args) {

        /*
        BasicSingleton b1 = BasicSingleton.getBasicSingletonInstance();
        BasicSingleton b2 = BasicSingleton.getBasicSingletonInstance();

        System.out.println(b1);
        System.out.println(b2);

        b1.displayBasicSingleton();
        b2.displayBasicSingleton();
        
        */
        //-------------------------------------------

        /*
        ThreadSafeSingleton t1 = ThreadSafeSingleton.getThreadSafeSingletonInstance();
        ThreadSafeSingleton t2 = ThreadSafeSingleton.getThreadSafeSingletonInstance();

        System.out.println(t1);
        System.out.println(t2);
        
        */
        //-------------------------------------------
        



    }
    
}
