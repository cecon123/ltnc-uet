
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
        Animal a = new Dog();
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Đây không phải là Mèo!");
        }
    }
}
