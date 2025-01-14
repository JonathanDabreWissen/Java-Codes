// This program demonstrates the use of instanceof operator in Java. The instanceof operator is used to test whether the object is an instance of the specified type (class or subclass or interface). It returns either true or false. If we apply the instanceof operator with any variable that has null value, it returns false. It is better to use the instanceof operator if we have to perform different operations on the object based on its type.


class Animal{

}

class Dog extends Animal{

}

class RandomTestClass extends Dog{}

class InstanceOfExampleClass{

    public static void main(String args[]){

        Animal a = new Dog();

        System.out.println(a instanceof Dog);
        System.out.println(a instanceof Animal);
        System.out.println(a instanceof RandomTestClass);
    }
}