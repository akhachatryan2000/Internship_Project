package thisandsuper;

public class Main {
    public static void main(String[] args) {
        BMW bmw1 = new BMW(2);
        bmw1.show();
        Car car = new Car();
        System.out.println(car.maxSpeed);
        Car car1 = new BMW();
        System.out.println(car1.maxSpeed);
        car1.drive();


    }
}
