package references;

public class PersonBuilder {

    public static Person buildPerson(String n, int id) {
        return new Person(n, id);
    }
}
