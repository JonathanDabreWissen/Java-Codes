// package Assignments;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.regex.*;

abstract class Employ {
    int empId;
    String name;
    String designation;
    int salary;
    int age;

    static int employCount = 1;

    public void display() {
        System.out.println("\nHere are the employ details");
        System.out.println("Employ ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
        System.out.println();
    }

    public static boolean validAge(int age) {

        if (age < 21 || age > 60) {
            return false;
        }
        return true;
    }

    public static boolean validName(String name) {
        String nameRegex = "^[A-Z][a-z]* [A-Z][a-z]*$";

        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);
        if (nameMatcher.find()) {
            return true;
        }

        return false;
    }

    Employ(int empId, String name, int age, String designation, int salary) {
        this.empId = empId;
        employCount++;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;

        System.out.println("\nCreated Employ Successfully");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employ ID: " + empId);
        System.out.println("Designation: " + designation);
        System.out.println("Base Salary: " + salary);
        System.out.println();

    }

    String getStringForCSV() {
        String newRow = String.valueOf(this.empId) + "," + this.name + "," + String.valueOf(this.age) + ","
                + this.designation + "," + String.valueOf(this.salary) + "\n";
        return newRow;
    }

    abstract void raiseSalary(int empId);

}

final class Clerk extends Employ {

    Clerk(int id, String name, int age) {
        super(id, name, age, "Clerk", 25000);
    }

    Clerk(int id, String name, int age, int salary){
        super(id, name, age, "Clerk", salary);

    }

    void raiseSalary(int empId) {
        System.out.println("\nRaised salary of " + this.name + " ,Employ ID: " + this.empId);

        this.salary = this.salary + 1000;
        System.out.println("Salary now: " + this.salary);

    }
}

final class Programmer extends Employ {

    Programmer(int id, String name, int age) {
        super(id, name, age, "Programmer", 50000);
    }
    Programmer(int id, String name, int age, int salary){
        super(id, name, age, "Programmer", salary);
    }

    void raiseSalary(int empId) {
        System.out.println("\nRaised salary of " + this.name + " ,Employ ID: " + this.empId);

        this.salary = this.salary + 2000;
        System.out.println("Salary now: " + this.salary);

    }

}

final class Manager extends Employ {

    Manager(int id, String name, int age) {
        super(id, name, age, "Manager", 100000);
    }

    Manager(int id, String name, int age, int salary){
        super(id, name, age, "Manager", salary);
    }

    void raiseSalary(int empId) {
        System.out.println("\nRaised salary of " + this.name + " ,Employ ID: " + this.empId);

        this.salary = this.salary + 10000;
        System.out.println("Salary now: " + this.salary);

    }

}

class UserException extends Exception {
    public UserException() {
        super();
    }

    public UserException(String msg) {
        super(msg);
    }

}

class NameSorter implements Comparator<Employ> {
    public int compare(Employ e1, Employ e2) {
        return e1.name.compareTo(e2.name);
    }
}

class DesignationSorter implements Comparator<Employ> {
    public int compare(Employ e1, Employ e2) {
        return e1.designation.compareTo(e2.designation);
    }
}

class IdSorter implements Comparator<Employ> {
    public int compare(Employ e1, Employ e2) {
        return Integer.valueOf(e1.empId).compareTo(e2.empId);
    }
}

class SalarySorter implements Comparator<Employ> {
    public int compare(Employ e1, Employ e2) {
        return Integer.valueOf(e1.salary).compareTo(e2.salary);
    }
}

class AgeSorter implements Comparator<Employ> {
    public int compare(Employ e1, Employ e2) {
        return Integer.valueOf(e1.age).compareTo(e2.age);
    }
}

class EmployManagementWithPersistentData {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, Employ> employMap = new TreeMap<Integer, Employ>();

        try (RandomAccessFile raf = new RandomAccessFile("employees.csv", "r")) {
            raf.readLine(); // To Skip header

            String record;
            while ((record = raf.readLine()) != null) {
                String[] fields = record.split(",");
                int tempId = Integer.parseInt(fields[0]);
                String tempName = fields[1];
                int tempAge = Integer.parseInt(fields[2]);
                String tempDesignation = fields[3];
                int tempSalary = Integer.parseInt(fields[4]);

                Employ tempEmploy = null;
                if (tempDesignation == "Clerk") {
                    tempEmploy = new Clerk(tempId, tempName, tempAge, tempSalary);
                } else if (tempDesignation == "Programmer") {
                    tempEmploy = new Programmer(tempId, tempName, tempAge, tempSalary);
                } else {
                    tempEmploy = new Manager(tempId, tempName, tempAge, tempSalary);
                }

                employMap.put(tempId, tempEmploy);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        int choice = 0;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Create Employ");
            System.out.println("2. Display Employs");
            System.out.println("3. Raise Salary");
            System.out.println("4. Remove Employ");
            System.out.println("5. Search Employ");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                scanner.nextLine();
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("1. Clerk \n2. Programmer \n3. Manager \n");
                        System.out.print("Enter your choice of Employ: ");
                        int empChoice;
                        try {
                            empChoice = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }

                        scanner.nextLine();

                        int id;
                        while (true) {
                            System.out.print("Enter Employ ID: ");
                            try {
                                id = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input format");
                                scanner.nextLine();
                                continue;
                            }
                            if (employMap.containsKey(id)) {
                                System.out.println("Employ ID already exists");
                                continue;
                            }
                            break;
                        }
                        scanner.nextLine();

                        String empName;
                        while (true) {

                            System.out.print("Enter employ name: ");
                            empName = scanner.nextLine();

                            if (!Employ.validName(empName)) {
                                System.out.println("Invalid Name");
                                continue;
                            }
                            break;
                        }

                        int age;

                        while (true) {

                            try {
                                System.out.print("Enter age: ");
                                age = scanner.nextInt();
                                if (!Employ.validAge(age)) {
                                    throw new UserException("Invalid Age");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input format");
                                scanner.nextLine();
                                continue;
                            } catch (UserException e) {
                                System.out.println("Reason: " + e.getMessage());
                                continue;

                            }
                            break;

                        }

                        Employ tempEmploy = null;

                        if (empChoice == 1) {
                            tempEmploy = new Clerk(id, empName, age);
                        } else if (empChoice == 2) {
                            tempEmploy = new Programmer(id, empName, age);
                        } else if (empChoice == 3) {
                            tempEmploy = new Manager(id, empName, age);
                        } else {
                            System.out.println("Check your choice.");
                        }

                        if (tempEmploy != null) {
                            employMap.put(id, tempEmploy);

                            try (RandomAccessFile raf = new RandomAccessFile("employees.csv", "rw")) {
                                raf.seek(raf.length());
                                String newRow = tempEmploy.getStringForCSV();
                                raf.writeBytes(newRow);
                                
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }

                        tempEmploy = null;
                    }

                    case 2 -> {

                        System.out.println("1. ID \n2. Name \n3. Salary \n4. Designation \n5. Age\n");
                        System.out.print("Enter your sorting choice: ");
                        int sortChoice;
                        try {
                            sortChoice = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }

                        scanner.nextLine();

                        if (sortChoice == 1) {
                            System.out.println("Displaying Employs sorted by ID");
                            for (Object key : employMap.keySet()) {
                                Employ tempEmploy = (Employ) employMap.get(key);
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }
                        } else if (sortChoice == 2) {
                            System.out.println("Displaying Employs sorted by Name");
                            List<Employ> employList = new ArrayList<>(employMap.values());
                            Collections.sort(employList, new NameSorter());
                            for (Employ tempEmploy : employList) {
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }
                        } else if (sortChoice == 3) {
                            System.out.println("Displaying Employs sorted by Salary");
                            List<Employ> employList = new ArrayList<>(employMap.values());
                            Collections.sort(employList, new SalarySorter());
                            for (Employ tempEmploy : employList) {
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }
                        } else if (sortChoice == 4) {
                            System.out.println("Displaying Employs sorted by Designation");
                            List<Employ> employList = new ArrayList<>(employMap.values());
                            Collections.sort(employList, new DesignationSorter());
                            for (Employ tempEmploy : employList) {
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }
                        } else if (sortChoice == 5) {
                            System.out.println("Displaying Employs sorted by Designation");
                            List<Employ> employList = new ArrayList<>(employMap.values());
                            Collections.sort(employList, new AgeSorter());
                            for (Employ tempEmploy : employList) {
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }
                        }

                    }

                    case 3 -> {
                        System.out.println("This will raise salary");
                        System.out.print("Enter the Employ ID: ");
                        int empId;
                        try {
                            empId = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }

                        if (employMap.get(empId) == null) {
                            System.out.println("\nEmploy doesn't exist");
                        } else {
                            Employ tempEmploy = (Employ) employMap.get(empId);
                            tempEmploy.raiseSalary(empId);
                        }
                    }

                    case 4 -> {
                        System.out.print("Enter the Employ ID: ");
                        int empId;
                        try {
                            empId = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }

                        if (employMap.get(empId) == null) {
                            System.out.println("Employ doesn't exist");
                        } else {
                            Employ tempEmploy = (Employ) employMap.get(empId);
                            tempEmploy.display();
                            employMap.remove(empId);
                            System.out.println("Above Employ has been removed");
                        }

                    }

                    case 5 -> {
                        System.out.println("1. ID \n2. Name \n3. Designation\n");
                        System.out.print("Enter your method of search: ");
                        int searchChoice;
                        try {
                            searchChoice = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }

                        scanner.nextLine();

                        if (searchChoice == 1) {
                            System.out.print("Enter the Employ ID: ");
                            int empId;
                            try {
                                empId = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input format");
                                scanner.nextLine();
                                continue;
                            }

                            if (employMap.get(empId) == null) {
                                System.out.println("Employ doesn't exist");
                            } else {
                                Employ tempEmploy = (Employ) employMap.get(empId);
                                tempEmploy.display();
                            }
                        } else if (searchChoice == 2) {
                            String empName;
                            while (true) {

                                System.out.print("Enter employ name: ");
                                empName = scanner.nextLine();

                                if (!Employ.validName(empName)) {
                                    System.out.println("Invalid Name");
                                    continue;
                                }
                                break;
                            }

                            List<Employ> nameList = new ArrayList<>();
                            for (Employ tempEmploy : employMap.values()) {
                                if (tempEmploy.name.equals(empName)) {
                                    nameList.add(tempEmploy);
                                }
                            }
                            Collections.sort(nameList, new NameSorter());
                            for (Employ tempEmploy : nameList) {
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }

                        } else if (searchChoice == 3) {
                            System.out.println("1. Clerk \n2. Programmer \n3. Manager\n");
                            System.out.print("Enter your choice of Designation: ");
                            int designationChoice;
                            try {
                                designationChoice = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input format");
                                scanner.nextLine();
                                continue;
                            }

                            String designation = "Clerk";
                            if (designationChoice == 2) {
                                designation = "Programmer";
                            } else if (designationChoice == 3) {
                                designation = "Manager";
                            }

                            List<Employ> nameList = new ArrayList<>();
                            for (Employ tempEmploy : employMap.values()) {
                                if (tempEmploy.designation.equals(designation)) {
                                    nameList.add(tempEmploy);
                                }
                            }
                            Collections.sort(nameList, new NameSorter());
                            for (Employ tempEmploy : nameList) {
                                tempEmploy.display();
                                System.out.println("----------------------");
                            }
                        }

                    }

                    case 6 -> {
                        scanner.close();
                        System.out.println("Exiting the code");
                    }

                    default -> {
                        System.out.println("Check your choice");
                    }

                }
            } finally {
                try (RandomAccessFile raf = new RandomAccessFile("employees.csv", "rw")) {
                    raf.setLength(0);

                    raf.seek(0);
                    String header = "id,name,age,designation,salary\n";
                    raf.writeBytes(header);
                    for (Object key : employMap.keySet()) {
                        Employ tempEmploy = (Employ) employMap.get(key);
                        String newRow = tempEmploy.getStringForCSV();
                        raf.writeBytes(newRow);
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

        } while (choice != 6);
    }

}