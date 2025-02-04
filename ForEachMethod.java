import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class A implements Consumer<String>{
    public void accept(String str){
        System.out.println("Good name is: " +str);
    }
}

class B implements Consumer<String>{
    public void accept(String str){
        System.out.println("Written to CSV file: "+str);
    }
}

class C {
    public static void writeToFile(String str){
        System.out.println("Written to file: " +str);
    }
}

public class ForEachMethod {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Suman", "Sujatha", "Supriya", "Sunita");
        employees.forEach(new A());
        employees.forEach(new B());
        employees.forEach(C::writeToFile);
        employees.forEach((arg)->System.out.println("Printing: "+arg));
        employees.forEach(System.out::println);
    }
}
