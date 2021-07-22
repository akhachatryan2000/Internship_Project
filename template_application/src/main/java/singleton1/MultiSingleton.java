package singleton1;

public final class MultiSingleton {
    private static volatile MultiSingleton singleton;
    public String value;

    private MultiSingleton(String value) {
        this.value = value;
    }

    public static MultiSingleton getSingleton(String value) {
        if (singleton != null) {
            return singleton;
        }
        synchronized (MultiSingleton.class) {
            if (singleton==null) {
                singleton= new MultiSingleton(value);
            }
    }
        return singleton;
}

}
