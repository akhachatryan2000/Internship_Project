package DesignPatterns.Prototype;

import java.util.ArrayList;

public class Dick implements Person {

    private ArrayList arrayList = new ArrayList();

    private final String name = "Dick";

    @Override
    public Person clone() {
        return new Dick();
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    @Override
    public String toString() {
        return "Dick{" +
                "name='" + name + '\'' +
                '}';
    }
}
