package DesignPatterns.Prototype2;

import java.util.HashMap;
import java.util.Map;

public class PersonFactory {

    static Map<String, Person> prototypes = new HashMap<>();

    static {
        prototypes.put("Dick", new Dick());
        prototypes.put("Harry", new Harry());
        prototypes.put("Tom", new Tom());
    }

    public static Person getClonedPerson(String name) {
        try {
            Person person = prototypes.get(name).clonePerson();
            return person;

        } catch (NullPointerException exception) {
            System.out.println("No such person to copy");
            return null;
        }
    }

}
