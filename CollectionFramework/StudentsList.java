import java.util.*;

class Student {
    int rollNo;
    String name;
    int standard;

    public Student(int rn, String n, int s){
        rollNo = rn;
        name = n;
        standard = s;
    }

    public String toString(){
        System.out.println("Roll No: " +rollNo);
        System.out.println("Name: " +name);
        System.out.println("Standard: " +standard);
        return "";
    }

    public int hashCode(){
        return standard;
    }

    public boolean equals(Object obj){
        Student s = (Student)obj;
        if(rollNo == s.rollNo && name.equals(s.name) && standard == s.standard){
            return true;
        }
        return false;
    }

    public int compareTo(Object obj){
        Student s = (Student)obj;
        return name.compareTo(s.name)*-1;
    }

}

class NameSorter implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}

class RollNoSorter implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return Integer.valueOf(s1.rollNo).compareTo(s2.rollNo);
    }
}

class StandardSorter implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return Integer.valueOf(s1.standard).compareTo(s2.standard);
    }
}

public class StudentsList {
    public static void main(String[] args) {
        //HashSet hs = new HashSet();
        TreeSet hs = new TreeSet(new RollNoSorter());

        hs.add(new Student(11, "Pintu", 5));
        hs.add(new Student(22, "Rinku", 6));
        // hs.add(new Student(22, "Rinku", 6));
        hs.add(new Student(33, "Sanju", 5));
        hs.add(new Student(44, "Manju", 4));
        hs.add(new Student(55, "Rita", 5));
        hs.add(new Student(66, "Sita", 6));

        Iterator i = hs.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
