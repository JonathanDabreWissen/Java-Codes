public class InitBlock {
    {
        System.out.println("For demo....");
    }
    {
        System.out.println("Init block 2");
    }
    static{
        System.out.println("Static block 1");
    }
    InitBlock(){
        System.out.println("From Demo() constructor");
    }

    InitBlock(int i){
        System.out.println("From Demo(int) constructor");
    }

    InitBlock(String s){
        System.out.println("From Demo(String) constructor");
    }

    static{
        System.out.println("From Static block2");
    }
    {
        System.out.println("Init block 3");
    }
    public static void main(String[] args) {
        System.out.println("From main method");

        InitBlock d1 = new InitBlock();
        InitBlock d2 = new InitBlock(11);
        InitBlock d3 = new InitBlock("Hello");
        

    }
}
