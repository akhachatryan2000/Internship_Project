package DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("Mercedes");
        System.out.println(car.getBrand());
        car.setTopSpeed(40);
        car.getTopSpeed();
        System.out.println(car.toString());
        Car car1 = new Car(car);
        System.out.println(car1.toString());
    }
}
