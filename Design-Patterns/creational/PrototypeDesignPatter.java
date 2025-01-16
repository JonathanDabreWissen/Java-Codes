
class Student{


}

public class PrototypeDesignPatter {
    Student s1 = new Student();
    Student s2 = s1.clone();
    Student s3 = s1.clone();
    Student s4 = s1.clone();
}
