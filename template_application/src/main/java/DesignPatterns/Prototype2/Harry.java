package DesignPatterns.Prototype2;

public class Harry implements Person {
    private final String name = "Harry";

    @Override
    public Person clonePerson() {
        return new Harry();
    }

    @Override
    public String toString() {
        return "Harry{" +
                "name='" + name + '\'' +
                '}';
    }
}
