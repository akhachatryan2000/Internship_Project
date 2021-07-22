package prototype1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapeCopies = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.color = "red";
        shapes.add(circle);

        Circle circle1 = (Circle) circle.clone();
        shapes.add(circle1);
        cloneAndCompare(shapes,shapeCopies);

    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println("Shapes are different objects");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println("And they are identical");
                } else {
                    System.out.println("But they are not identical");
                }

            } else {
                System.out.println("Shape objects are the same");
            }
        }
    }
}