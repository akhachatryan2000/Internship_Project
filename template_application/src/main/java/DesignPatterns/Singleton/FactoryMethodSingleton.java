package DesignPatterns.Singleton;

public class FactoryMethodSingleton {
    private static final FactoryMethodSingleton instance = new FactoryMethodSingleton();

    private FactoryMethodSingleton() {

    }

    public static FactoryMethodSingleton getInstance() {
        return instance;
    }

}
