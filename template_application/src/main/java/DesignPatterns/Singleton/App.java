package DesignPatterns.Singleton;

public class App {
    private static App app; //single threaded lazy initialization

    private App() {
    }

    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }
}
