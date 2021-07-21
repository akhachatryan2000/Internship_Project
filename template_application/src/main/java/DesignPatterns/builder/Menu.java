package DesignPatterns.builder;

import java.util.HashMap;

public class Menu {

    private HashMap<String, String> parts = new HashMap<>();

    public void add(String part) {
        parts.put(part,part);

    }

    @Override
    public String toString() {
        return "Menu contains " +
                parts + ", "
                ;
    }
}
