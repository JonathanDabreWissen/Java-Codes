interface Adder{
    int add(int a, int b);
}

public class FunctionalInterfaceWithLambdaFunction {
    public static void main(String[] args) {
        Adder sum1 = (a, b)->{
            return a+b;
        };
        System.out.println(sum1.add(2, 3));

        Adder sum2 =(a, b)->a+b;
        System.out.println(sum2.add(5,4));

        Runnable r = ()->{
            System.out.println("This is a lambda implementation of runnable interface ");
        };

        Thread t1 = new Thread(r);
        t1.start();
    }
}
