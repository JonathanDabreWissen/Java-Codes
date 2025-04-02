public class CopyConstructor{

	public static void main(String args[]){
		Person p1 = new Person("Rohit", 37, 45);
		Person p2 = new Person(p1);

		System.out.println("Original: " + p1.name + ", " + p1.age + ", " + p1.id);
		System.out.println("Clone: " + p2.name + ", " + p2.age + ", " + p2.id);	
	}
}

class Person{

	String name;
	int age;
	int id;

	Person(String name, int age, int id){
		this.name = name;
		this.age = age;
		this.id = id;
	}

	//Copy constructor
	Person (Person another){
		this.name = another.name;
		this.age = another.age;
		this.id = another.id;
	}
}