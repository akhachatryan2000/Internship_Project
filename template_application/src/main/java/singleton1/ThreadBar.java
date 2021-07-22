package singleton1;

public class ThreadBar implements Runnable {
    @Override
    public void run() {
        MultiSingleton multiSingleton = MultiSingleton.getSingleton("Bar");
        System.out.println(multiSingleton.value);

    }
}
