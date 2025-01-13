package com.assignment.employManagement;

import java.util.Scanner;

abstract class Employ{
	int empId;
	String name;
	String designation;
	int salary;

	static int employCount = 0;

	public void display(){
		System.out.println("Here are the employee details");
		System.out.println("Employ ID: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Designation: " +designation);
		System.out.println("Salary: " +salary);
	}
	
	Employ(String name, String designation, int salary ){
		this.empId = employCount +1;
		employCount++;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		
		
	}

	abstract void raiseSalary(int empId);


}


final class Clerk extends Employ{

	Clerk(String name ){
		super(name, "Clerk", 25000);		
	}
	
	void raiseSalary(int empId){
		System.out.println("Hey raise salary");
		this.salary = this.salary + 1000;
	}
}

final class Programmer extends Employ{
	
	Programmer(String name ){
		super(name, "Programmer", 50000);	
	}
	
	void raiseSalary(int empId){
		System.out.println("Hey raise salary");
		this.salary = this.salary + 2000;

	}


}

final class Manager extends Employ{
	
	Manager(String name){
		super(name, "Manager", 100000);
	}

	void raiseSalary(int empId){
		System.out.println("Hey raise salary");
		this.salary = this.salary + 10000;
	}

}


class Assignment{

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		Employ[] employs = new Employ[10];

		int choice;
		

		do{
			System.out.println("Menu");
			System.out.println("1. Create Employ" );
			System.out.println("2. Display Employ");
			System.out.println("3. Raise Salary");
			System.out.println("4. Remove Employ");
			System.out.println("5. Exit");

			System.out.print("\nEnter your choice: ");

			choice = scanner.nextInt();

			switch(choice){
				case 1: 
					System.out.println("1. Clerk \n2. Programmer \n3. Manager \n");
					System.out.print("Enter your choice of Employ: ");
					int empChoice = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter employ name: ");
					String empName = scanner.nextLine();
					
					if(empChoice == 1){
						employs[Employ.employCount] = new Clerk(empName);
						
					}
					else if(empChoice == 2){
						employs[Employ.employCount] = new Programmer(empName);
					}
					else if(empChoice == 3){
						employs[Employ.employCount] = new Manager(empName);
					}
					else{
						System.out.println("Check your choice");
					}
					break;
					

				case 2: 
					System.out.print("Enter the Employ ID:");
					int empId = scanner.nextInt();
					
					if(empId>Employ.employCount){
						System.out.println("Employ doesn't exist");
					}
					else if(employs[empId] == null){
						System.out.println("Employ doesn't exist anymore");
					}
					else{
						employs[empId].display();
					}
					break;


				case 3: 
					System.out.println("This will raise salary");
					System.out.print("Enter the Employ ID:");
					empId = scanner.nextInt();
					if(empId>Employ.employCount){
						System.out.println("Employ doesn't exist");
					}
					else if(employs[empId] == null){
						System.out.println("Employ doesn't exist anymore");
					}
					else{
						employs[empId].raiseSalary(empId);
					}
					break;
				
				case 4: 
					System.out.print("Enter the Employ ID");
					empId = scanner.nextInt();

					if(empId>Employ.employCount){
						System.out.println("Employ doesn't exist");
					}
					else if(employs[empId] == null){
						System.out.println("Employ doesn't exist anymore");
					}
					else{
						employs[empId].display();
						employs[empId] = null;
						System.out.println("Above Employ has been removed");
					}

					break;		
					
				case 5: 
					System.out.println("Exiting the code");
					break;
				
				default: 
					System.out.println("Check your choice");

			}
			
		
		} while(choice != 5);
	}
	
}