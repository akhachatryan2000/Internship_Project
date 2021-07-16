package InheritanceExercises3;

public class Square extends Rectangle {

    public Square() {
    }


    public Square(double side) {
        super(side, side);
    }


    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setWidth(side);

    }
    public double getSide() {
        return getWidth();
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public double getLenght() {
        return super.getLenght();
    }

    @Override
    public void setLenght(double side) {
        super.setLenght(side);
    }

    @Override
    public String toString() {
        return "A square with side  56565" +
                " and the subclass of " + super.toString() + "}";
    }

}
