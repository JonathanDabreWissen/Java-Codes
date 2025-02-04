interface I{
    void abc();
}

interface J{
    Object getObject();
}
class A{

    public A(){
        System.out.println("From constructor A()");
    }
    public static void classMethod(){
        System.out.println("From static class method");;
    }

    public void instanceMethod(){
        System.out.println("From instance method");
    }
}

class B{

    public static void  demo(){
        System.out.println("From B class method demo()");
    }
}

class C{
    C(){
        System.out.println("C class object created");
    }
    public String toString(){
        System.out.println("From C class object");
        return "";
    }
}

public class MethodReference {

    public static void main(String[] args) {
        /*
        I i1 = ()->{
            System.out.println("Lambda expression for functional interface");
        };

        i1.abc();

         */

        I i1 = A::classMethod;
        i1.abc();

        I i2 = new A() :: instanceMethod;
        i2.abc();

        I i3 = A::new;
        i3.abc();

        I i4 = B::demo;
        i4.abc();

        J j1 = C::new;
        // Object obj = j1.getObject();

        J j2 = new C()::toString;
        Object obj2 = j2.getObject();


    }
}