package Singleton;

// Singleton class
class Singleton {
    // Private static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Optional: Add initialization code here
    }

    // Public static method to get the single instance of the class
    public static Singleton getInstance() {
        // Check if instance is null
        if (instance == null) {
            // If instance is null, create a new instance
            instance = new Singleton();
        }
        // Return the instance
        return instance;
    }

    // Other methods and variables can be defined here
}

// Main class to demonstrate the usage of Singleton
public class Main {
    public static void main(String[] args) {
        // Get the single instance of Singleton
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        // Check if s1 and s2 are the same instance
        System.out.println(s1 == s2); // Output: true
    }
}
