public class Exam {
    public static void main(String[] args) {
        new A();
    }
}

class A{
    {System.out.println(1);}
    static{
        System.out.println("static 1");
    }
    {
        System.out.println(2);
    }
    static{
        System.out.println("static 2");
    }
}
