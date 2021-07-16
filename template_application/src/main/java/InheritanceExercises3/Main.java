package InheritanceExercises3;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        Square square1 = new Square(5);
        System.out.println(square1.getPerimeter());
        System.out.println(square1.getArea());
        System.out.println(square1.getLenght());

        Square square2 = new Square(4);
        System.out.println(square2.getSide());
        square2.setSide(3);
        System.out.println(square2.getSide());



    }
}
