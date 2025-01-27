interface Shape{

    double calculateArea();
}

class Rectangle implements Shape{
    private double length;
    private double breadth;


    Rectangle(double length, double breadth ){

        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea(){
        return (length * breadth);
    }

    public double getLength(){
        return length;
    }

    public double getbreadth(){
        return breadth;
    }
}

class Circle implements Shape{

    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    public double calculateArea(){
        return (3.14 * radius * radius);
    }

    public double getRadius(){
        return radius;
    }
}

class Triangle implements Shape{

    private double base;
    private double height;


    Triangle(double base, double height ){

        this.base = base;
        this.height = height;
    }

    public double calculateArea(){
        return (0.5 * base * height);
    }

    public double getBase(){
        return base;
    }

    public double getHeight(){
        return height;
    }
}


class AreaCalculator{

   public double getTotalArea(Shape[] shapes){

        double totalArea = 0;

        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }

        return totalArea;
   }
}

public class OpenClosedPrinciple{

    public static void main(String[] args) {
        

        Triangle t1 = new Triangle(5, 10);
        Circle c1 = new Circle(10);
        Rectangle r1 = new Rectangle(10, 20);
        AreaCalculator a1 = new AreaCalculator();

        Shape [] shapes = {t1, c1, r1};

        System.out.println(a1.getTotalArea(shapes));
    }
}

/*
The Open-Closed Principle (OCP) states that a class should be open for extension but closed for modification. This means that you should be able to extend the behavior of a class without modifying its source code.
*/