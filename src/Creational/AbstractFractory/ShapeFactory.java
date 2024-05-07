package Creational.AbstractFractory;

public class ShapeFactory extends AbstractFactory {
    public Color getColor(String color) {
        return null;

    }

    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        } else if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("REGTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}
