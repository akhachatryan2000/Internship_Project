package DesignPatterns.Structural.Adapter;

public class EnglishMan {
    public void readTranslatedData() {
        TranslatorAdapter translatorAdapter = new TranslatorAdapter();
        String[] results = translatorAdapter.translateToEnglish();
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");

        }
    }

}
