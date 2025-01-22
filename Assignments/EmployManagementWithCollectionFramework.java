// package Assignments;

import java.util.*;
import java.util.regex.*;

abstract class Employ{
	int empId;
	String name;
	String designation;
	int salary;
	int age;

	static int employCount = 1;

	public void display(){
		System.out.println("\nHere are the employ details");
		System.out.println("Employ ID: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Designation: " +designation);
		System.out.println("Salary: " +salary);
		System.out.println();
	}
	
	public static boolean validAge(int age){

		if(age<21 || age>60){
			return false;
		}
		return true;
	}

	public static boolean validName(String name){
		String nameRegex = "^[A-Z][a-z]* [A-Z][a-z]*$";

		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if(nameMatcher.find()){
			return true;
		}

		return false;
	}

	Employ(int empId, String name, int age, String designation, int salary ){
		this.empId = empId;
		employCount++;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		
		
		System.out.println("\nCreated Employ Successfully");
		System.out.println("Name: " +name);
		System.out.println("Age: " +age);
		System.out.println("Employ ID: " +empId);
		System.out.println("Designation: " +designation);
		System.out.println("Base Salary: " +salary);
		System.out.println();
		
		
	}

	abstract void raiseSalary(int empId);


}


final class Clerk extends Employ{

	Clerk(int id, String name, int age ){
		super(id, name, age, "Clerk", 25000);		
	}
	
	void raiseSalary(int empId){
		System.out.println("\nRaised salary of " +this.name +" ,Employ ID: " + this.empId);

		this.salary = this.salary + 1000;
		System.out.println("Salary now: " +this.salary);

	}
}

final class Programmer extends Employ{
	
	Programmer(int id, String name, int age ){
		super(id, name, age, "Programmer", 50000);	
	}
	
	void raiseSalary(int empId){
		System.out.println("\nRaised salary of " +this.name +" ,Employ ID: " + this.empId);

		this.salary = this.salary + 2000;
		System.out.println("Salary now: " +this.salary);

	}


}

final class Manager extends Employ{
	
	Manager(int id, String name, int age){
		super(id, name, age, "Manager", 100000);
	}

	void raiseSalary(int empId){
		System.out.println("\nRaised salary of " +this.name +" ,Employ ID: " + this.empId);

		this.salary = this.salary + 10000;
		System.out.println("Salary now: " +this.salary);

	}

}

class UserException extends Exception{
	public UserException(){
		super();
	}
	public UserException(String msg){
		super(msg);
	}
	
}


class EmployManagementWithCollectionFramework{

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
        TreeMap employMap = new TreeMap();

		int choice = 0;
		

		do{
			System.out.println("\nMenu");
			System.out.println("1. Create Employ" );
			System.out.println("2. Display Employs");
			System.out.println("3. Raise Salary");
			System.out.println("4. Remove Employ");
			System.out.println("5. Search Employ");
			System.out.println("6. Exit");
			
			System.out.print("\nEnter your choice: ");
		

			try{
				choice = scanner.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input format");
				scanner.nextLine();
				continue;

			}
			

			switch(choice){
				case 1 -> { 
					System.out.println("1. Clerk \n2. Programmer \n3. Manager \n");
					System.out.print("Enter your choice of Employ: ");
					int empChoice; 
					try{
						empChoice = scanner.nextInt();
					}
					catch(InputMismatchException e){
						System.out.println("Invalid input format");
						scanner.nextLine();
						continue;
					}
					
					scanner.nextLine();

                    int id;
                    while(true){
                        System.out.print("Enter Employ ID: ");
                        try{
                            id = scanner.nextInt();
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }
                        if(employMap.containsKey(id)){
                            System.out.println("Employ ID already exists");
                            continue;
                        }
                        break;
                    }
                    scanner.nextLine();

					String empName;
					while(true){
						
						System.out.print("Enter employ name: ");
						empName = scanner.nextLine();

						if(!Employ.validName(empName)){
							System.out.println("Invalid Name");
							continue;
						}
						break;
					}

					int age; 

					while(true){

						try{	
							System.out.print("Enter age: ");
							age = scanner.nextInt();
							if(!Employ.validAge(age)){
								throw new UserException("Invalid Age");
							}
						}
						catch(InputMismatchException e){
							System.out.println("Invalid input format");
							scanner.nextLine();
							continue;
						}
						catch(UserException e){
							System.out.println("Reason: " +e.getMessage());
							continue;
						
						}
						break;

					}
					
					
					if(empChoice == 1){
                        Employ tempEmploy = new Clerk(id, empName, age);
                        employMap.put(id, tempEmploy);
						
					}
					else if(empChoice == 2){
                        Employ tempEmploy = new Programmer(id, empName, age);
                        employMap.put(id, tempEmploy);
					}
					else if(empChoice == 3){
						// employs[Employ.employCount] = new Manager(empName, age);
                        Employ tempEmploy = new Manager(id, empName, age);
                        employMap.put(id, tempEmploy);
					}
					else{
						System.out.println("Check your choice.");
					}
                }
					

				case 2 ->{ 
                        System.out.println("Displaying Employs");
                        for(Object key: employMap.keySet()){
                            Employ tempEmploy = (Employ) employMap.get(key);
                            tempEmploy.display();
                            System.out.println("----------------------");
                        }
                    }   


				case 3->{
                        System.out.println("This will raise salary");
                        System.out.print("Enter the Employ ID: ");
                        int empId;
                        try{
                            empId = scanner.nextInt();
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }

                        if(employMap.get(empId) == null){
                            System.out.println("\nEmploy doesn't exist");
                        }
                        else{
                            Employ tempEmploy = (Employ) employMap.get(empId);
                            tempEmploy.raiseSalary(empId);
                        }
                    }
                    
				case 4->{ 
                        System.out.print("Enter the Employ ID: ");
                        int empId;
                        try{
                            empId = scanner.nextInt();
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid input format");
                            scanner.nextLine();
                            continue;
                        }


                        if(employMap.get(empId) == null){
                            System.out.println("Employ doesn't exist");
                        }
                        else{
                            Employ tempEmploy = (Employ) employMap.get(empId);
                            tempEmploy.display();
                            employMap.remove(empId);
                            System.out.println("Above Employ has been removed");
                        }

                    }		
				
                case 5 ->{
                    System.out.print("Enter the Employ ID: ");
                    int empId;   
                    try{
                        empId = scanner.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Invalid input format");
                        scanner.nextLine();
                        continue;
                    }       
                    
                    if(employMap.get(empId) == null){
                        System.out.println("Employ doesn't exist");
                    }
                    else{
                        Employ tempEmploy = (Employ) employMap.get(empId);
                        tempEmploy.display();
                    }
				}


				case 6->{
					System.out.println("Exiting the code");
				}
                
				
				default->{
					System.out.println("Check your choice");
				} 

				

			}
			
		
		} while(choice != 6);
	}
	
}