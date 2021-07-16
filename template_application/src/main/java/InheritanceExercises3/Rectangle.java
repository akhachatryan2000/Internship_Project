package InheritanceExercises3;

public class Rectangle extends Shape {

    private double width;

    private double lenght;

    public Rectangle() {
        width = 1.0;
        lenght = 1.0;

    }

    public Rectangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    public Rectangle(String color, boolean filled, double width, double lenght) {
        super(color, filled);
        this.width = width;
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getArea() {
        return lenght * width;
    }

    public double getPerimeter() {
        return 2 * (lenght + width);
    }

    public void setLengthAndWidth(double w, double l) {
        setLenght(l);
        setWidth(w);
    }

    @Override
    public String toString() {
        return "A rectangle with width " + width + " and with length " + lenght +
                ". And the superclass is " + super.toString() +
                '}';
    }
}
