// package IO-Package;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class RAFDemo {
    public static void main(String[] args) {
        try {
            
            /*
            RandomAccessFile raf = new RandomAccessFile("abc.txt", "rw");

            // raf.seek(2);
            // System.out.println(raf.readLine());
            // System.out.println(raf.readLine());
            // System.out.println(raf.readLine());
            // System.out.println(raf.readLine());
            // raf.seek(raf.length());
            raf.writeBytes("Just for the demo using append\n");
            raf.close();
            */

            // PrintWriter pw = new PrintWriter(System.out);
            // PrintWriter pw = new PrintWriter(new FileOutputStream("abc.txt")); // Will overwrite the content
            PrintWriter pw = new PrintWriter(new FileOutputStream("abc.txt", true));
            pw.println("Hello Everybody\n");
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
