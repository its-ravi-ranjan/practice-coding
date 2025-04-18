 class  CAR {
    String name;
    String brand;
    String color;


    // constructor if we not write this here then java by default handle this
     CAR(String name,String brand,String color){
         this.name = name;
         this.brand = brand;
         this.color = color;
     }
   // example of polymorphisom in which same task doing in many ways same fn defined many times according to need we will use
    public void carInfo(String name,String brand,String color){
        System.out.println("Car name is"+ name+" Car brand is"+brand + "Car color is" + color);
    }

    public void carInfo(String name){
        System.out.println("Car name is"+name);
    }
    public void carInfo(String name,String brand){
        System.out.println("Car name is"+name+"Car brand is"+brand);
    }
}

class Shape {
    String color;
    public void area(){
        System.out.println("Area of shape is");
    }
}
class Circle extends Shape{
    int radius;

    public void area(int r) {
        double a= 3.14*r*r;
        System.out.println(a);
    }
}

 abstract class Animal {
     // Abstract method (no implementation)
     public abstract void makeSound();

     // Concrete method (with implementation)
     public void sleep() {
         System.out.println("Sleeping...");
     }
 }

 class Dog extends Animal {
     public void makeSound() {
         System.out.println("Woof woof!");
     }
 }

 interface Vehical {
    public void makeSound();
 }

 class Car implements Vehical {
    public void makeSound(){
        System.out.println("Po Po");
    }
 }
public class OOPS {
    public static void main(String[] args){
      CAR car1 = new CAR("Honda City","Honda","Blue");
      // these are needed when manually not add constructor in class
//      car1.name = "Honda City";
//      car1.brand = "Honda";
//      car1.color= "Blue";

      // polymorphisom
        // when you do same task in many ways
        // in car class carInfo method defined many times whatever value we will pass accordingly fn will be choosed
        car1.carInfo("Honda city");
        car1.carInfo("Honda city","Honda");
        car1.carInfo("Honda city","honda","blue");

        // inheritance
        // using this one class inherit property of other class , the class who will inherit property will be called
        // child class and the class whose value inherited will be called parent class
        // type : - single level inheritence, multi level inheritence, herarchy inheritence, hybrid inheritence

        // access modifier
        // public > using this access modifier we can access method outside the class
        // default (no need to write) > it can access method within package but not out side package
        //  protected > we can access this within class but if i want to access outside class then we need to create subclass
        // private > we can only access this within class , no subclass will access this, like if we create object using this class then we can't use that private method
         // for using private method or fn we use getter and setter fn within class

        //Encapsulation
        // using this we encapsulate data nd its method of class just like we create any method within class and
        // we are using class data like this.name etc , this is called encapsulation
        // using encapsulation we can implement data hiding concept using access meodifier

        //Abstraction
        // It is the process of hiding implementation details from the user and only exposing the necessary functionalities but different from data hiding
        // like animal class is not going to create object because animal is not any type of animal so only we need its method so we make its abstract
        // The Dog class inherits from Animal and provides the implementation of the abstract method.
        // we use abstract keyword to make abstract also we use interfaces
        Dog dog1 = new Dog();
        dog1.makeSound();

        // interfaces
        // we can make abstraction using interface which will be 100 % abstraction.
        // in this no constructor
        // all field s in interfaces are public ,static and final by default means you can  not change
        //all methods are public and abstract by default
        // a class that implement a interface must implement all the method declared in the interface
        // we can use multiple inhertence using interface like this
        // class Horse implements Animal,Vehical {}
        // here vehical is interface and car implementing that interface


        // static keyword
        // if we define any parameter as static then it wil be same for all object
        // let say we have student class in which school key then it will be same for all so we make it static
        // also we don't need to make object to access these static key we can access using class itself
    }
}