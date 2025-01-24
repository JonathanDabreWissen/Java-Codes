import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Employee{
    private String name;
    private int age;
    private int salary;
    private String designation;
    public Employee(){
        readDetails();
    }


    public void readDetails(){
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter name:");
            name = br.readLine();
            age = Integer.parseInt(br.readLine());
            System.out.print("Enter salary:");
            salary = Integer.parseInt(br.readLine());
            System.out.print("Enter designation:");
            designation = br.readLine(); 
            writeToFIle();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public void writeToFIle(){
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv", true));
            pw.println(name + "," + age + "," + salary + "," + designation);
            pw.close();
        }
        catch(Exception e){
            System.out.println("Error:" + e);
        }
    }
}


public class ReadWriteFile {
    public static void main(String[] args) {
        int ch = 0;

        do{
            System.out.println("--------------------");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            System.out.println("--------------------");
            System.out.print("Enter your choice:");
        }while(ch != 3);
    }
}
