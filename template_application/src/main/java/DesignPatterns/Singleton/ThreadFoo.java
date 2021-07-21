package DesignPatterns.Singleton;

public class ThreadFoo implements Runnable{
    @Override
    public void run() {
        MultithreadedSingleton singleton=MultithreadedSingleton.getInstance("Foo");
        System.out.println(singleton.value);
    }
}
