public class ThrowsExample {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace
        }
    }

    public static void method1() throws Exception {
        method2();
    }

    public static void method2() throws Exception {
        throw new Exception("Something went wrong!");
    }
}
