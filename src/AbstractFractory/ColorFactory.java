package AbstractFractory;

public class ColorFactory extends  AbstractFactory{
    public Color getColor(String color){
        if(color==null){
            return null;

        }
        else if(color.equalsIgnoreCase("RED")){
            return new Red();

        }
        else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;

    }

    Shape getShape(String Shape) {
        return null;
    }
}
