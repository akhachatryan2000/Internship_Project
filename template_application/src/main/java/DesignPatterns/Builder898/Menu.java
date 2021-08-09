package DesignPatterns.Builder898;

import java.util.HashMap;

public class Menu {

    HashMap<String, String> wholeMenu= new HashMap<>();

    public void add(String part) {
        wholeMenu.put(part,part);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "wholeMenu=" + wholeMenu +
                '}';
    }
}
