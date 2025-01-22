
class A<T>{
    public void add(T a, T b){
        // System.out.println(a+b);
        System.out.println("Generic Logic");
    } 
    /* 
    public void add(double a, double b){
        System.out.println(a+b);
    }
    
    public void add(String a, String b){
        System.out.println(a+b);
    } 
    */  

    // if Return type is T
    public T sub(T a, T b){
        return a;
    }

    // if Return type is differet
    /* 
    public R mul(T a, T b){
        return null;
    }
    */


}

public class CustomGenerics {
    public static void main(String[] args) {
        A<Integer> a1 = new A<Integer>();
        a1.add(1, 2);

        A<String> a2 = new A<String>();
        a2.add("Hello", "World");

        A<Double> a3 = new A<Double>();
        a3.add(1.2, 2.3);
    }
}
