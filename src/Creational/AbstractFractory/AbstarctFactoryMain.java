package Creational.AbstractFractory;

public class AbstarctFactoryMain {
    public static void main(String args[]) {
        AbstractFactory shapefactory = FractoryProducer.getFactory("SHAPE");
        Shape shape = shapefactory.getShape("CIrcle");
        shape.draw();

        AbstractFactory colorfactory = FractoryProducer.getFactory("COLOR");
        Color color1 = colorfactory.getColor("RED");
        color1.Fill();
    }
}
