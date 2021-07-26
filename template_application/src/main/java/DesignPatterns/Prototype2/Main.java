package DesignPatterns.Prototype2;

public class Main {
    public static void main(String[] args) {
        Person person = new Dick();
        Person cloned = person.clonePerson();
        System.out.println(person);
        System.out.println(person.hashCode());
        System.out.println(cloned);
        System.out.println(cloned.hashCode());
    }
}
