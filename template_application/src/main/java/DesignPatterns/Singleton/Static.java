package DesignPatterns.Singleton;

public class Static {
    private static Static instance;

    static {
        try {
            instance = new Static();
        } catch (Exception e) {
            throw new RuntimeException("Exception while instantiating");

        }
    }

    private Static() {

    }

    public static Static getInstance() {
        return instance;
    }
}
