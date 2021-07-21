package DesignPatterns.Builder2;

import java.util.HashMap;

public class Menu {

    HashMap<String, String> wholeMenu = new HashMap<>();


    public void add(String menu) {
        wholeMenu.put(menu, menu);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "wholeMenu=" + wholeMenu +
                '}';
    }
}
