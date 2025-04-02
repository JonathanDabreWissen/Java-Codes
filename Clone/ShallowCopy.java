public class ShallowCopy{

	public static void main(String args[]) throws CloneNotSupportedException{
		
		Person p1 = new Person("Jonathan", new Address("Vasai"));
		Person p2 = (Person) p1.clone();
		
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

		System.out.println("So this was shallow copy, in which refrence object refer to same memory location, shallow copy doens't create independent copy");
		
		
	}
}


class Address{

	String city;

	Address(String city){

		this.city = city;
	}
}

class Person implements Cloneable{
	String name;
	Address address;

	Person (String name, Address address){
		this.name = name;
		this.address = address;
	}

	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}