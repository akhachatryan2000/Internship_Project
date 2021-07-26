package DesignPatterns.Singleton1;

public class ThreadFirst implements Runnable{
    @Override
    public void run() {
        MultiThreadInstance instance= MultiThreadInstance.getMultiThreadInstance();
        System.out.println("First Thread");
    }
}
