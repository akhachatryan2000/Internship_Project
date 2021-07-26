package DesignPatterns.Prototype2;

public class Tom implements Person {
    private final String name = "Tom";

    @Override
    public Person clonePerson() {
        return new Tom();
    }

    @Override
    public String toString() {
        return "Tom{" +
                "name='" + name + '\'' +
                '}';
    }
}
