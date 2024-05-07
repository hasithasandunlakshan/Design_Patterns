// Component interface
package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();
}

// Leaf class
class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Another Leaf class
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Composite class
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

// Client code
public class main {
    public static void main(String[] args) {
        // Creating leaf objects
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();

        // Creating composite object
        CompositeGraphic compositeGraphic1 = new CompositeGraphic();
        CompositeGraphic compositeGraphic2 = new CompositeGraphic();

        // Adding leaf objects to composite object
        compositeGraphic1.add(rectangle1);
        compositeGraphic1.add(circle1);
        compositeGraphic2.add(rectangle2);
        compositeGraphic2.add(circle2);

        // Creating another composite object
        CompositeGraphic allGraphics = new CompositeGraphic();

        // Adding both composite objects to another composite object
        allGraphics.add(compositeGraphic1);
        allGraphics.add(compositeGraphic2);

        // Drawing all graphics
        allGraphics.draw();
    }
}
