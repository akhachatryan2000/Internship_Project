package DesignPatterns.Structural.Adapter;

import java.util.ArrayList;

public class GermanBook {

    ArrayList<String> subtitles = new ArrayList<>();

    public void setSubtitles() {
        subtitles.add("lshdks");
        subtitles.add("shdjHS");
        subtitles.add("hsgdhgs");
    }

    public ArrayList<String> getSubtitles() {
        return subtitles;
    }
}
