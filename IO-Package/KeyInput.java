// package IO-Package;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyInput {
    public static void main(String[] args) {
        try {
            
            //Reads bytes stream from the keyboard, stores in to buffer, and then from buffer it is stored in name.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            System.out.print("Please enter you name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.println("Your good name is " +name);
            System.out.println("Your age after 10 years is " +(age + 10));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
