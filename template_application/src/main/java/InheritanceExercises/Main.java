package InheritanceExercises;

public class Main {
    public static void main(String[] args) {

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        System.out.println("Height is" + cylinder.getHeight());
        System.out.println("Radius is " + cylinder.getRadius());
        System.out.println("Area is " + cylinder.getArea());
        System.out.println("Volume is " + cylinder.getVolume());


        Cylinder cylinder1= new Cylinder(10.0);
        System.out.println(cylinder1);
        System.out.println("Height is" + cylinder1.getHeight());
        System.out.println("Radius is " + cylinder1.getRadius());
        System.out.println("Area is " + cylinder1.getArea());
        System.out.println("Volume is " + cylinder1.getVolume());

        Cylinder cylinder2= new Cylinder(2.0,10.0);
        System.out.println(cylinder2);
        System.out.println("Height is" + cylinder2.getHeight());
        System.out.println("Radius is " + cylinder2.getRadius());
        System.out.println("Area is " + cylinder2.getArea());
        System.out.println("Volume is " + cylinder2.getVolume());



    }
}
