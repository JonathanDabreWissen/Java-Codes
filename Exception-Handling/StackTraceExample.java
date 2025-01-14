public class StackTraceExample {
    public static void main(String[] args) {
        try {
            method1(); // Calls method1, which throws an exception
        } catch (Exception e) {
            e.printStackTrace(); // Catch and print stack trace
        }
    }

    public static void method1() throws Exception {
        method2(); // Calls method2, which throws an exception
    }

    public static void method2() throws Exception {
        throw new Exception("An error occurred in method2");
    }
}