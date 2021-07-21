package DesignPatterns.AbstractFactory1;

public class Main {
    public static void main(String[] args) {
        //Africa
        ContinentFactory continentFactory = new AfricaFactory();
        Ecosystem ecosystem = new Ecosystem(continentFactory);
        ecosystem.run();

        //Australia
        ContinentFactory continentFactory1 = new AustraliaFactory();
        Ecosystem ecosystem1 = new Ecosystem(continentFactory1);
        ecosystem1.run();


    }
}
