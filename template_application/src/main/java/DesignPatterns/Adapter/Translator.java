package DesignPatterns.Adapter;

public class Translator extends TranslatorAdapter {

    GermanBook  germanBook = new GermanBook();
    String[] titles;

    @Override
    public  String[] getTitles() {
        germanBook.setTitles();
        int i = 0;
        for (String title : GermanBook.getTitles()
        ) {
            title = titles[i];
            i++;

        }
        return titles;
    }
}
