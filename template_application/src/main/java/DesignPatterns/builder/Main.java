package DesignPatterns.builder;

public class Main {
    public static void main(String[] args) {
        MenuDirector director= new MenuDirector();
        MenuBuilder menuBuilder= new KidsMenuBuilder();
        director.construct(menuBuilder);
        Menu menu= menuBuilder.getResults();
        System.out.println("Kids menu" + menu);


    }
}
