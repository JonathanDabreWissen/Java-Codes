import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        //Without Predicates
        // evenNumbers(arr);
        // oddNumbers(arr);

        //With Predicates
        Predicate<Integer> p1 = (x)-> x%2==0;
        process(arr, p1);
        process(arr, p1.negate());

        Predicate<Integer> p2 = (x)-> x>50;
        process(arr, p2);
        process(arr, p2.negate());


        process(arr, p1.or(p2));
    }



    public static void evenNumbers(int arr[]){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%2 == 0){
                System.out.println(arr[i]);
            }
        }
        System.out.println("---------------------");
    }

    public static void oddNumbers(int arr[]){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%2 != 0){
                System.out.println(arr[i]);
            }
        }
        System.out.println("---------------------");
    }

    public static void process(int arr[], Predicate<Integer> p){
        for(int i =0; i<arr.length; i++){
            if(p.test(arr[i])){
                System.out.println(arr[i]);
            }
        }
        System.out.println("---------------------");

    }
}
