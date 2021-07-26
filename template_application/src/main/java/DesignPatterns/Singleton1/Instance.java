package DesignPatterns.Singleton1;

public final class Instance {
    private static Instance instance;

    private Instance() {

    }

    public static Instance getSingleInstance() {
        if (instance == null) {
            return instance = new Instance();
        }
        return instance;
    }

}
