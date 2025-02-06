// package Assignments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student{
    int rollNo;
    String name;
    int age;
    int standard;
    String school;
    String gender;
    float percentage;
    Fees f = null;

    Student(String name, int age, int standard, String school, String gender, float percentage, int totalFees, int feesPaid){
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.school = school;
        this.gender = gender;
        this.percentage = percentage;
        this.f = new Fees(totalFees, feesPaid);
    }

    public void payFees(int fees){
        f.feesPaid = fees;
    }

    public int getFeesPaid(){
        return f.feesPaid;
    }

    public int getFeesPending(){
        return (f.totalFees - f.feesPaid);
    }  
    
    public int getStandard(){
        return standard;
    }

}

class Fees{
    int totalFees;
    int feesPaid;

    Fees(int totalFees, int feesPaid){
        this.totalFees = totalFees;
        this.feesPaid = feesPaid;
    }

}
public class StudentStreamAssignment {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<Student>();
        
        studentList.add(new Student("Aarav Mehta", 14, 9, "Greenwood High", "Male", 88.5f, 50000, 30000));
        studentList.add(new Student("Saanvi Iyer", 13, 8, "Springfield Academy", "Female", 92.3f, 45000, 40000));
        studentList.add(new Student("Rohan Gupta", 15, 10, "Greenwood High", "Male", 85.2f, 55000, 25000));
        studentList.add(new Student("Ishika Sharma", 14, 9, "DPS International", "Female", 89.1f, 50000, 35000));
        studentList.add(new Student("Kabir Verma", 12, 7, "National Public School", "Male", 91.4f, 47000, 20000));

        studentList.add(new Student("Meera Nair", 13, 8, "Greenwood High", "Female", 87.6f, 50000, 45000));
        studentList.add(new Student("Aditya Kumar", 15, 10, "Springfield Academy", "Male", 90.2f, 55000, 50000));
        studentList.add(new Student("Ananya Das", 14, 9, "DPS International", "Female", 95.1f, 48000, 25000));
        studentList.add(new Student("Vikram Choudhary", 13, 8, "National Public School", "Male", 82.9f, 46000, 32000));
        studentList.add(new Student("Tanya Mishra", 14, 9, "Greenwood High", "Female", 89.5f, 50000, 47000));

        studentList.add(new Student("Arjun Singh", 15, 10, "Springfield Academy", "Male", 34.3f, 53000, 30000));
        studentList.add(new Student("Priya Menon", 12, 7, "National Public School", "Female", 92.7f, 45000, 42000));
        studentList.add(new Student("Yash Patel", 13, 8, "DPS International", "Male", 85.9f, 48000, 35000));
        studentList.add(new Student("Simran Kaur", 14, 9, "Greenwood High", "Female", 91.2f, 50000, 38000));
        studentList.add(new Student("Rahul Joshi", 12, 7, "Springfield Academy", "Male", 26.8f, 47000, 42000));

        studentList.add(new Student("Neha Kapoor", 15, 10, "National Public School", "Female", 93.4f, 54000, 50000));
        studentList.add(new Student("Ritik Tiwari", 14, 9, "DPS International", "Male", 87.1f, 50000, 31000));
        studentList.add(new Student("Kavya Reddy", 13, 8, "Springfield Academy", "Female", 89.7f, 46000, 40000));
        studentList.add(new Student("Mohit Bhardwaj", 12, 7, "National Public School", "Male", 33.5f, 45000, 20000));
        studentList.add(new Student("Sakshi Agarwal", 15, 10, "Greenwood High", "Female", 94.2f, 52000, 50000));

        studentList.add(new Student("Aakash Nanda", 14, 9, "Springfield Academy", "Male", 88.1f, 47000, 39000));
        studentList.add(new Student("Diya Banerjee", 13, 8, "DPS International", "Female", 91.8f, 49000, 25000));
        studentList.add(new Student("Nirav Shah", 15, 10, "National Public School", "Male", 45.6f, 53000, 47000));
        studentList.add(new Student("Anushka Jain", 14, 9, "Greenwood High", "Female", 90.9f, 50000, 44000));
        studentList.add(new Student("Harsh Goel", 12, 7, "Springfield Academy", "Male", 87.4f, 48000, 33000));

        studentList.add(new Student("Ishaan Deshmukh", 13, 8, "National Public School", "Male", 89.0f, 46000, 30000));
        studentList.add(new Student("Manya Saxena", 14, 9, "DPS International", "Female", 93.2f, 50000, 35000));
        studentList.add(new Student("Kartik Malhotra", 12, 7, "Greenwood High", "Male", 86.7f, 48000, 20000));
        studentList.add(new Student("Riya Bansal", 15, 10, "Springfield Academy", "Female", 32.5f, 55000, 50000));
        studentList.add(new Student("Siddharth Roy", 14, 9, "National Public School", "Male", 88.8f, 49000, 39000));

        System.out.println("How many students in each standard?");
        Map<Integer, Long> studentStandardWise = studentList.stream().collect((Collectors.groupingBy(s->s.standard, Collectors.counting())));
        System.out.println(studentStandardWise);
        
        
        System.out.println("\nHow many students male & female?");
        Map<String, Long> m2 = studentList.stream().collect((Collectors.groupingBy(s->s.gender, Collectors.counting())));
        System.out.println(m2);

        System.out.println("\nHow many students have failed and pass (40%)? \n(University-wise)");
        Map<Boolean, Long> m3 = studentList.stream().collect((Collectors.partitioningBy(s->s.percentage>=40, Collectors.counting())));
        System.out.println(m3);
        System.out.println("Pass: " +m3.get(true));
        System.out.println("Fail: " +m3.get(false));

        System.out.println("\nHow many students have failed and pass (40%)? \n(School-wise)");
        Map<String, Map<Boolean, Long>> m4 = studentList.stream()
            .collect(Collectors.groupingBy(
                s->s.school,
                Collectors.partitioningBy(s->s.percentage>=40,
                    Collectors.counting()
                )
            ));

        System.out.println(m4);


        System.out.println("\nTop 3 students \n(Whole university)");
        List<Student> l1 = studentList.stream()
            .sorted(Comparator.comparingDouble(s->-s.percentage))
            .limit(3)
            .collect(Collectors.toList());
        
        l1.forEach((s)->{
                System.out.println(s.name + ": " +s.percentage +"%");
            }
        );


        System.out.println("\nTop 3 students \n(School-wise)");
        Map<String, List<Student>> schoolWiseTopScorrerMap = studentList.stream()
            .collect(
                Collectors.groupingBy(
                    s->s.school,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                            .sorted(Comparator.comparingDouble(s->-s.percentage))
                            .limit(3)
                            .collect(Collectors.toList())
                    )
                )
                
            );

            schoolWiseTopScorrerMap.forEach((school, students) -> {
                System.out.println("\nSchool: " + school);
                students.forEach(s -> System.out.println(s.name + " - " + s.percentage + "%"));
            });

            System.out.println("\nAverage age of male & female students");
            Map<String, Double> averageAgeMap = studentList.stream()
                .collect(
                    Collectors.groupingBy(s->s.gender),
                    Collectors.toList().
                )


    }
}

/*

Student
--------
rollNo
name
age
standard
school
gender
percentage
 
Fees
------
totalFees
feesPaid
feesPending
 
 
* How many students in each standard
* How many students male & female
* How many students have failed and pass (40%)
	- Whole university
	- School wise
* Top 3 students (Whole university)
* Top scorer school wise
* Average age of male & female students
* Total fees collected school wise
* Total fees pending school wise
* Total number of students (University)
 */
