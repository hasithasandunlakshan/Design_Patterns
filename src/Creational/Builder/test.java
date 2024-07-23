// House.java
 class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    // Getters and setters
    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + ", interior=" + interior + "]";
    }
}

// HouseBuilder.java
interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void buildInterior();
    House getHouse();
}

// ConcreteHouseBuilder.java
class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete Foundation");
        System.out.println("ConcreteHouseBuilder: Foundation complete.");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Concrete Structure");
        System.out.println("ConcreteHouseBuilder: Structure complete.");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Concrete Roof");
        System.out.println("ConcreteHouseBuilder: Roof complete.");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Wooden Interior");
        System.out.println("ConcreteHouseBuilder: Interior complete.");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Director.java
class Director {
    private HouseBuilder houseBuilder;

    public Director(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse() {
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        houseBuilder.buildInterior();
    }

    public House getHouse() {
        return houseBuilder.getHouse();
    }
}

// Client.java
public class test {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new ConcreteHouseBuilder();
        Director director = new Director(houseBuilder);

        director.constructHouse();
        House house = director.getHouse();

        System.out.println("House is: " + house);
    }
}
