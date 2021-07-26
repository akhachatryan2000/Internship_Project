package DesignPatterns.Singleton1;

public class Main {
    public static void main(String[] args) {
        Instance instance = Instance.getSingleInstance();
        System.out.println(instance);
        Instance instance1 = Instance.getSingleInstance();
        System.out.println(instance1);


        Thread threadFirst = new Thread(new ThreadFirst());
        Thread threadSecond = new Thread(new ThreadSecond());
        threadFirst.start();
        threadSecond.start();
    }
}
