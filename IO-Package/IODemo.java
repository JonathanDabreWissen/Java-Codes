// package IO-Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.File;

public class IODemo {
    public static void main(String[] args) {
        try {
            
            BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter file name: ");
            String fname = br.readLine();
            
            File f = new File(fname);
            // System.out.println(f.exists());
            // System.out.println(f.canRead());
            // System.out.println(f.isDirectory());
            // System.out.println(f.length());
            // System.out.println(f.getName());
            // System.out.println(f.getPath());
            // System.out.println(f.toString());
            // System.out.println(f.getFreeSpace());
            // System.out.println();
            
            if(f.exists()){
                BufferedReader fr = new BufferedReader(new FileReader(fname));
                String line = null;

                

                while((line = fr.readLine()) != null ){
                    System.out.println(line);
                }
                
                fr.close();
                // f.delete();
            }
            else{
                System.out.println("Sorry!! File doesn't exist");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

        



    }   
}
