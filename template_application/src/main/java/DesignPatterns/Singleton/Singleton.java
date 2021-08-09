package DesignPatterns.Singleton;

public enum Singleton {

    Instance;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
