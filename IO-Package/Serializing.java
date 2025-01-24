import java.io.*;


public class Serializing {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Sumitra";
        p1.age = 25;

        try {
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
            oos.writeObject(p1);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Serialized successfully");

    }
}
