interface Greeting{
    void greet();
}

public class AnonnymousClass {
    public static void main(String[] args) {
       
        Greeting g = new Greeting() {
            public void greet(){
                System.out.println("Namaste!!");
            }
        };

        g.greet();
    }
}
