package DesignPatterns.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        //this is for Africa continent
        ContinentFactory continentFactory = new AfricaFactory();
        Ecosystem ecosystem = new Ecosystem(continentFactory);
        ecosystem.run();

        ContinentFactory continentFactory1 = new AustraliaFactory();
        Ecosystem ecosystem1 = new Ecosystem(continentFactory1);
        ecosystem1.run();
    }
}
