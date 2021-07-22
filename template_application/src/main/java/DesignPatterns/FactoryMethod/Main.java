package DesignPatterns.FactoryMethod;

public class Main {
    public static void main(String[] args) {

        ToyCreator creator = new FireTruckCreator();
        System.out.println("Creating a new FireTruck toy");

        creator.makeToy();
        System.out.println();

        //create a superman

        creator = new SupermanCreator();
        creator.makeToy();


    }
}
