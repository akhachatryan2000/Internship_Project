package DesignPatterns.Prototype;

public class Tom implements Person {
    private final String name = "Tom";

    @Override
    public Person clone() {
        return new Tom();
    }

    @Override
    public String toString() {
        return "Tom{" +
                "name='" + name + '\'' +
                '}';
    }
}
