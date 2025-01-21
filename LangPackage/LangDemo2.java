import java.util.*;
import java.lang.reflect.*;

class Employee{
    public void raiseSalary(){
        System.out.println("Salary raised");
    }
    public void display(){

    }

}

class Clerk extends Employee{

    int age;
    int Salary;

    Clerk(){
        this.age = 0;
        this.Salary = 0;
    }

    Clerk(int age, int Salary){
        this.age = age;
        this.Salary = Salary;
    }

    
    public String toString(){
        return "Clerk class";
    }
}

class A{
    int x;

    A(int x){
        this.x = x;
    }
    public void finalize(){
        System.out.println("Object with x value: " +x +" is getting removed ... ");
    }
}

public class LangDemo2 {
    public static void main(String[] args) throws Exception {
        A a1 = new A(10);
        A a2 = new A(20);
        A a3 = new A(30);

        // a2.finalize();
        
        System.out.println(a1.x);
        System.out.println(a2.x);
        System.out.println(a3.x);

        a2 = null;
        // a1 = null;
        a3 = null;  
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        //Class c1 = a1.getClass();


        System.out.println("Enter class name: ");
        Class c2 = Class.forName(new Scanner(System.in).nextLine());
        Object obj = c2.newInstance();
        System.out.println(obj);
        
        Field[] fields = c2.getDeclaredFields();
        Method[] methods = c2.getDeclaredMethods();
        Constructor [] constructors = c2.getDeclaredConstructors();


        System.out.println("List of Methods below:");
        for(Method m: methods){
            System.out.println(m);
        }
        
        System.out.println("List of fields below:");
        for(Field f: fields){
            System.out.println(f);
        }
        
        System.out.println("List of constructors below:");
        for(Constructor c: constructors){
            System.out.println(c);
        }


    }
}
