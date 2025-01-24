import java.util.List;

public class Invariant {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Number> numList = List.of(1.1, 2.2, 3.3);

        intList = numList; // Compilation error: Incompatible types
        numList = intList; // Compilation error: Incompatible types
    }
}
