package DesignPatterns.AbstractFactory898;

public class Main {

    public static void main(String[] args) {
        ContinentFactory continentFactory= new AfricaFactory();
        Ecosystem ecosystem= new Ecosystem(continentFactory);
        ecosystem.run();
    }
}
