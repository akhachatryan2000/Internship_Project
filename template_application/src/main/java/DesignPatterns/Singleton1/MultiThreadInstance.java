package DesignPatterns.Singleton1;

public final class MultiThreadInstance {
    private static volatile MultiThreadInstance instance;

    private MultiThreadInstance() {

    }

    public static MultiThreadInstance getMultiThreadInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (MultiThreadInstance.class) {
            if (instance == null) {
                instance = new MultiThreadInstance();

            }

            return instance;
        }

    }
}
