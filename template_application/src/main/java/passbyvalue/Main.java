package passbyvalue;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("red");
        Bicycle bicycle = new Bicycle("green");
        swap(car, bicycle);
        System.out.println(car);
        System.out.println(bicycle);


    }

    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        System.out.println(o1);
        o2 = temp;
        System.out.println(o2);
    }

}
