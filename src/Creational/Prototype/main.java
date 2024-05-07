package Creational.Prototype;

class animal {
    String name;

    public animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal Sound");
    }
}

class Dog extends animal {
    public Dog(String name) {
        super(name);

    }

    @Override
    public void makeSound() {
        System.out.println("baw baw");
    }

}

class Cat extends animal {
    public Cat(String name) {
        super(name);

    }

    @Override
    public void makeSound() {
        System.out.println("Meaw");
    }

}

public class main {
    public static void main(String[] args) {

        animal animal = new animal("elephant");
        System.out.println(animal.name);
        animal an2 = new Dog("dog1");
        System.out.println(an2.name);
        Dog dog2 = new Dog("dog2");
        System.out.println(dog2.name);

    }

}
