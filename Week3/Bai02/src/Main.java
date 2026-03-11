class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meows meows");
    }
}

class Duck extends Animal {
 
}

public class Main {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[4];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();
        for (Animal a : zoo) {
            a.makeSound();
        }
    }
}