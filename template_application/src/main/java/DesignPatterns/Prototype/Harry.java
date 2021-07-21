package DesignPatterns.Prototype;

public class Harry implements Person {

    private final String name="Harry";

    @Override
    public Person clone() {
        return new Harry();
    }

    @Override
    public String toString() {
        return "Harry{" +
                "name='" + name + '\'' +
                '}';
    }
}
