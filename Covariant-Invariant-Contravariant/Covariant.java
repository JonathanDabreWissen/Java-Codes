// package Covariant-Invariant-Contravariant;
import java.util.List;


public class Covariant{
    public static void printList(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        printList(intList);    // Allowed because Integer extends Number
        printList(doubleList); // Allowed because Double extends Number
    }
}
