// package SOLID-Principles;

class Animal{

    String name;


    Animal(String name){
        this.name = name;
    }

    String nomenclature(){
        return name;
    }
}

class Sound{

    String name ;
    String sound;

    Sound(String name, String sound){
        this.name = name;
        this.sound = sound;
    }

    void makeSound(){
        System.out.println(sound);
    }
}

class Feeding{

    String name;
    String feedingType;


    Feeding(String name, String feedingType){
        this. name = name;
        this.feedingType = feedingType;
    }

    void revealFeedingType(){
        System.out.println("The animal " +name +" is of feeding type: " +feedingType);
    }
}

public class SingleResponsibilityPrinciple {
    
    public static void main(String[] args) {
        
        Animal a1 = new Animal("Cat");
        Feeding f1 = new Feeding("Cat", "Carnivorous");
        Sound s1 = new Sound("Cat", "Meow");
    
        System.out.println(a1.nomenclature());
        f1.revealFeedingType();
        s1.makeSound();

    }



}


/*
Single responsibility principle just says that make classes for single responsibility
don't fill a single class with multiple responsibilities.

 */
