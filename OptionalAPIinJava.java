import static java.time.Month.valueOf;

import java.util.Optional;
import java.util.Scanner;

public class OptionalAPIinJava {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String name = null;
        // name = sc.nextLine();

        Optional<String> nameCheck = Optional.ofNullable(name);

        nameCheck.ifPresentOrElse(
                (n)->System.out.println("Hello "+n +"!!"), 
                ()->System.out.println("Ok no value")
            );

        
        Optional <String> valueNotNeeded = Optional.empty();
        valueNotNeeded = Optional.of("Jonathan");

        valueNotNeeded.ifPresent((value)->System.out.println("Here I am " + value));

        sc.close();
    }
}
