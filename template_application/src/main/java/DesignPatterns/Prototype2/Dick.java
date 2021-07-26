package DesignPatterns.Prototype2;

public class Dick implements Person{

    private final String name="Dick";

    @Override
    public Person clonePerson() {
        return new Dick();
    }

    @Override
    public String toString() {
        return "Dick{" +
                "name='" + name + '\'' +
                '}';
    }
}
