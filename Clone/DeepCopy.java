public class DeepCopy{

	public static void main(String args[]){
		Person p1 = new Person("Jonathan", new Address("Vasai"));
		Person p2 = new Person(p1.name, p1.address);
		
		System.out.println("Both clone objects before any changes");
		System.out.println("Original: " + p1.name + ", " + p1.address.city);
		System.out.println("Cloned: " + p2.name + ", " + p2.address.city);

		System.out.println("\nNow let's make change to Primitive field in original and see if it reflects in cloned object");
		p1.name = "Simona";
		System.out.println("Original: " + p1.name + ", " + p1.address.city);
		System.out.println("Cloned: " + p2.name + ", " + p2.address.city);

		
		System.out.println("\nNow we saw that making changes to Primitive field of original object doesn't affect the cloned object");
		System.out.println("Now we will make change to refrenced object of the original object and then compare it with the cloned object");

		p1.address.city = "Virar";
		System.out.println("Original: " + p1.name + ", " + p1.address.city);
		System.out.println("Cloned: " + p2.name + ", " + p2.address.city);

	
	}
}

class Address{

	String city;

	Address(String city){
		this.city = city;
	}

	Address (Address original){
		this.city = original.city;
	}
}

class Person{
	String name;
	Address address;
	
	Person(String name, Address address){
		this.name = name;
 		this.address = new Address(address);
	}
}

