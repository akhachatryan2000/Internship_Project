package DesignPatterns.Singleton1;

public class ThreadSecond implements Runnable {


    @Override
    public void run() {
        MultiThreadInstance instance = MultiThreadInstance.getMultiThreadInstance();
        System.out.println("Second thread ");

    }
}
