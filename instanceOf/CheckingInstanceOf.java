
class Animal {
    void bark(){
        System.out.println();
    }
 }
class Dog extends Animal {
    void bark() {
        System.out.println("Woof!");
    }
}


public class CheckingInstanceOf {
    public static void main(String[] args) {
        Animal animal = new Animal();
        // Animal animal = new Dog();
        

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bark();
        } else {
            System.out.println("animal is not a Dog");
        }
        

    }   
}
