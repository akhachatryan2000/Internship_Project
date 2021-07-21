package DesignPatterns.Singleton;

public class ThreadBar implements Runnable {
    @Override
    public void run() {
        MultithreadedSingleton singleton= MultithreadedSingleton.getInstance("Bar");
        System.out.println(singleton.value);

    }
}
