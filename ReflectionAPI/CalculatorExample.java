// package ReflectionAPI;

import java.lang.reflect.Method;
import java.util.*;

class Calculator{

	public int add(int a, int b)
	{
		return a+b;
	}
	public int sub(int a, int b)
	{
		return a-b;
	}
	public int mul(int a, int b)
	{
		return a*b;
	}
	public int div(int a, int b)
	{
		return a/b;
	}
}

public class CalculatorExample {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        Class calClass = Class.forName("Calculator");


        Object calObj = calClass.newInstance();

        Method[] methods = calClass.getDeclaredMethods();

        System.out.println("Choose from list of Methods below: ");
        for(Method m: methods){
            System.out.println(m.getName() + ", ");
        }

        System.out.println();

        System.out.print("Enter method name: ");
        String choiceMethod = sc.nextLine();

        Method methodCollected = calClass.getMethod(choiceMethod, int.class, int.class);

        System.out.print("Enter parameter one: ");
        int para1 = sc.nextInt();

        System.out.print("Enter parameter two: ");
        int para2 = sc.nextInt();

        Object result = methodCollected.invoke(calObj, para1, para2);

        System.out.println("Result: " +result);


    }
}
