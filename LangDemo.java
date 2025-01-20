/*
public class LangDemo {
    public static void main(String[] args) {
        String str1 = "Hi";
        System.out.println(str1);

        str1 = "hello";
        System.out.println(str1);

        str1 = str1.toUpperCase();
        System.out.println(str1);

        String s1 = "hi";
        String s2 = "hello"; 
        String s3 = "thanks"; 

        String s4 = "hi";
        String s5 = "hello"; 
        String s6 = "thanks"; 
        
        String s7 = "hi";
        String s8 = "hello"; 
        String s9 = "thanks"; 
        
        String s10 = "hi";
        String s11 = "hello"; 
        String s12 = "thanks"; 

        //only 3 objects are created above
        

    } 
}


*/

public class LangDemo{

    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        System.out.println("See magic in 10 seconds");

        Thread.sleep(10000);

        Process p1 = rt.exec("notepad.exe");
        Thread.sleep(5000);
        
        Process p2 = rt.exec("mspaint.exe");
        Thread.sleep(5000);
        
        Process p3 = rt.exec("calc.exe");
        Thread.sleep(5000);

        System.out.println("Just wait for another 10 seconds to watch it disappear");
        Thread.sleep(10000);

        p3.destroy();
        Thread.sleep(5000);

        p2.destroy();
        Thread.sleep(5000);

        p1.destroy();

    }
}

