package DesignPatterns.Adapter;

public class Englishman {

    public void readTranslatedData() {
        Translator translator = new Translator();
        String[] titles = translator.getTitles();
        for (int i = 0; i < titles.length; i++) {
            System.out.println(titles[i]);
        }
    }
}
