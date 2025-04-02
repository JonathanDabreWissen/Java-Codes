//Its Shallow copy
//Steps 
//Implement Cloneable (Marker Interface)
//Override clone()
//Use super.clone() to create the copy

public class CloneMethod{

	public static void main(String args[]) throws CloneNotSupportedException{

		Person p1 = new Person("Jonathan", 21, 1);
		Person p2 = new Person("Simona", 21, 2);
		
		Person cp1 = (Person) p1.clone();
		Person cp2 = (Person) p2.clone();
		
		System.out.println("Original: " + p1.name + ", " + p1.age + ", " + p1.id);
		System.out.println("Clone: " + cp1.name + ", " + cp1.age + ", " + cp1.id);
		
		System.out.println("Original: " + p2.name + ", " + p2.age + ", " + p2.id);
		System.out.println("Clone: " + cp2.name + ", " + cp2.age + ", " + cp2.id);
		
	}
}

class Person implements Cloneable{

	String name;
	int age;
	int id;

	Person(String name, int age, int id){
		this.name = name;
 		this.age = age;
		this.id = id;
	}	
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone(); // Performs shallow copy
	}
}