public class AnnonymusClassVSLambdaFunction {
    public static void main(String[] args) {
        
        //Annonymus class
        Runnable r1 = new Runnable(){
            public void run(){
                System.out.println("This is implementation of run method of runnable interface through annonymous class");
            }
        };

        Thread t1 = new Thread(r1);

        t1.start();


        //Lambda Expression
        Runnable r2 = ()->{
            System.out.println("This is implementation of run method of runnable interface from Lambda Function. ");
        };

        Thread t2 = new Thread(r2);
        t2.start();


    }
}
