package Polymorphism;

// Base class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Derived class 1
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Derived class 2
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        // Reference of type Animal holding an object of type Dog
        Animal myDog = new Dog();
        // Reference of type Animal holding an object of type Cat
        Animal myCat = new Cat();

        // Calling the overridden method makeSound() on both objects
        myDog.makeSound();  // Output: Dog barks
        myCat.makeSound();  // Output: Cat meows
    }
}
