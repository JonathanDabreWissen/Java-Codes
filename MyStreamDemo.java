import java.util.*;
import java.util.stream.Collectors;

public class MyStreamDemo {
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("Jonathan", "Simona","Milissa", "Laeven", "Mary", "Manuel", "Hema", "Louis");

        names.stream().filter(name ->name.startsWith("M")).map(String::toUpperCase).forEach(System.out::println);
        List<String> filterNames = names.stream().filter(name->name.length()<5).collect(Collectors.toList());
        System.out.println(filterNames);
        Long count = names.stream().filter(name->name.length()<5).collect(Collectors.counting());
        System.out.println(count);
        Long count2 = names.stream().filter(name->name.length()<5).count();
        System.out.println(count2);

        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);




    }
}
