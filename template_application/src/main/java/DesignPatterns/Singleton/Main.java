package DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("Foo");
        Singleton anotherSingleton = Singleton.getInstance("Bar");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);


        System.out.println("Multithreaded singleton");
        Thread threadFoo= new Thread(new ThreadFoo());
        Thread threadBar= new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();

    }
}
