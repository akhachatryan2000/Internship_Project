package singleton1;

public class ThreadFoo implements Runnable {
    @Override
    public void run() {
        MultiSingleton multiSingleton= MultiSingleton.getSingleton("Foo");
        System.out.println(multiSingleton.value);

    }
}