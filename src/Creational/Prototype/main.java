package Creational.Prototype;



// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype
class ConcretePrototype implements Prototype {
    private int value;

    public ConcretePrototype(int value) {
        this.value = value;
    }

    @Override
    public ConcretePrototype clone() {
        return new ConcretePrototype(this.value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class main {
    public static void main(String[] args) {
        // Create prototype
        ConcretePrototype prototype = new ConcretePrototype(10);

        // Clone prototype
        ConcretePrototype clonedPrototype = prototype.clone();

        // Test cloning
        System.out.println("Original Prototype Value: " + prototype.getValue());
        System.out.println("Cloned Prototype Value: " + clonedPrototype.getValue());

        System.out.println(prototype == clonedPrototype);

        // Modify cloned prototype
        clonedPrototype.setValue(20);

        // Test modification
        System.out.println("Modified Cloned Prototype Value: " + clonedPrototype.getValue());

    }
}