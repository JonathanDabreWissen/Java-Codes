
class A {
    private static A a1 = null;
    A(){
        if(this instanceof B){
            System.out.println("B object created");
        }
        else if(this instanceof A && a1 == null){
            System.out.println("A object created");
        }
        else{
            throw new RuntimeException("Cannot Create more than one object of A class");
        }
    }

    public static A getA(){
        if(a1 == null){
            a1 = new A();
        }
        
        return a1;
    }
}

class B extends A{
    private static B b1 = new B();

    private B(){
        
        System.out.println("B object created");
    }

    public static B getB(){
        return b1;
    }
}


class NotMoreThanOneObjectException extends Exception{
    public NotMoreThanOneObjectException(){
        super();
    }
    public NotMoreThanOneObjectException(String msg){
        super(msg);
    }
}

public class SingletonAssignment {
    public static void main(String[] args) {
        A a1 = A.getA();
        B b1 = B.getB();
        A a2 = A.getA();
        B b2 = B.getB();
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);
        
        
        A a3 = new A();
        System.out.println(a3);
    }   
}

// * Should be able to create only 1 object of A class
// * Should be able to create only 1 object of B class
// * If tried to create more than 1 object of any of these two classes, then exception should be raised