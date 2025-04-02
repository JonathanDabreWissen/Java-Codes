public class TypeCastingExceptionDemo{
	

	public static void main(String args[]){
		Animal animal = new Cat(); //Upcasting
		animal.sound();

		Cat cat = new Cat(); //Normal
		cat.sound();

		//Let's downcast cat to Animal
		Cat cat2 = (Cat) animal; 
		cat2.sound();
		

		//Let's downcast actual Animal() to Cat();
		Animal animal2 = new Animal();
		//Cat cat3 = (Cat) animal2;
		//cat3.sound();

		System.out.println("Is animal instance of Cat: " + (animal instanceof Cat));
		System.out.println("Is cat instance of Cat: " + (cat instanceof Cat));
		System.out.println("Is cat instance of Animal: " + (cat instanceof Animal));
		System.out.println("Is cat2 instance of Animal: " + (cat2 instanceof Animal));
		System.out.println("Is cat2 instance of Cat: " + (cat2 instanceof Cat));
		System.out.println("Is animal2 instance of Animal: " + (animal2 instanceof Animal));
		System.out.println("Is animal2 instance of Cat: " + (animal2 instanceof Cat));
		
	}
}


class Animal{

	void sound(){
		System.out.println("Animal makes a sound");
	}
}

class Cat extends Animal{
	void sound(){
		System.out.println("Meow");
	}
}