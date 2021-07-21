package DesignPatterns.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        ToyCreator creator=null;
        System.out.println("Creating a new FireTruck toy");

        //create a Fire TRuck
        creator= new FireTruckCreator();
        creator.makeToy();
        System.out.println();

        //create a superman

        creator= new SupermanCreator();
        creator.makeToy();


    }
}
