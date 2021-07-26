package DesignPatterns.Adapter;

import java.util.ArrayList;
import java.util.List;

public class GermanBook {
    private static List<String> titles = new ArrayList<>();

    public void setTitles() {
        titles.add("jdgksjk");
        titles.add("skkjsdj");
        titles.add("hskdasd");
    }

    public static List<String> getTitles() {
        return titles;
    }
}
