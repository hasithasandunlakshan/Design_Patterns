package Factory;

interface Character {
    String attack();
}

class Warrior implements Character {
    @Override
    public String attack() {
        return "Warrior attacks with a sword!";
    }
}

class Mage implements Character {
    @Override
    public String attack() {
        return "Mage attacks with a magic spell!";
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter();
}

class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Warrior();
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Mage();
    }
}

public class Main {
    public static void main(String[] args) {
        CharacterFactory warriorFactory = new WarriorFactory();
        Character warrior = warriorFactory.createCharacter();
        System.out.println(warrior.attack()); // Output: Warrior attacks with a sword!

        CharacterFactory mageFactory = new MageFactory();
        Character mage = mageFactory.createCharacter();
        System.out.println(mage.attack()); // Output: Mage attacks with a magic spell!
    }
}
