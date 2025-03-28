// package JavaComandLine;

import java.util.Scanner;

public class JpsCommand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String tp = sc.nextLine();
        sc.close();

        System.out.println(tp);
    }
}
