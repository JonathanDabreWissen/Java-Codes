
interface pet{}
interface wildAnimal{}

class Cat implements pet{};



public class InstanceOfExampleInterface {
    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c instanceof pet);
        System.out.println(c instanceof Cat);
        System.out.println(c instanceof wildAnimal);

    }
}
