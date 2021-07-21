package DesignPatterns.Singleton;

public final class MultithreadedSingleton {
    private static volatile MultithreadedSingleton instance;
    public String value;

    private MultithreadedSingleton(String value) {
        this.value = value;
    }

    public static MultithreadedSingleton getInstance(String value) {
        MultithreadedSingleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new MultithreadedSingleton(value);
            }
            return instance;
        }
    }
}

