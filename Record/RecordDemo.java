record Person(String name, int age){
	
}

public class RecordDemo{
	
	public static void main(String args[]){
		Person person = new Person("Jonathan", 21);

		System.out.println("Name:" + person.name());
		System.out.println("Age: " + person.age());
		
		//Using built-in to string method
		System.out.println("Person details: " + person);

		//Checking equality 
		Person anotherPerson = new Person("Jonathan", 21);
		
		System.out.println("Are they equal?" + person.equals(anotherPerson));
	}

}