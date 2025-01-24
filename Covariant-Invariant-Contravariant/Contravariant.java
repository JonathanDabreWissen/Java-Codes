import java.util.List;
import java.util.ArrayList;

public class Contravariant {
    public static void addToList(List<? super Integer> list) {
        list.add(42); // Allowed because Integer is compatible with the lower bound
    }

    public static void main(String[] args) {
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addToList(numList); // Allowed because Number is a superclass of Integer
        addToList(objList); // Allowed because Object is a superclass of Integer

        System.out.println(numList); // Output: [42]
        System.out.println(objList); // Output: [42]
    }
}
