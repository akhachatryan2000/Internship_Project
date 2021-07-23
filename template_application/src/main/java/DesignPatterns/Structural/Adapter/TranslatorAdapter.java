package DesignPatterns.Structural.Adapter;

import java.util.ArrayList;

public class TranslatorAdapter extends Translator {
    GermanBook germanBook = new GermanBook();

    @Override
    public String[] translateToEnglish() {
        int i = 0;
        String[] array = new String[3];
        germanBook.setSubtitles();
        ArrayList<String> subtitles = germanBook.getSubtitles();
        for (String s : subtitles) {
            array[i] = s;
            i++;
        }
        return array;


    }

}

