package DesignPatterns.Builder898;

public class Main {
    public static void main(String[] args) {
        MenuBuilder menuBuilder = new SaladMenuBuilder();
        MenuDirector menuDirector = new MenuDirector();
        menuDirector.construct(menuBuilder);
        Menu menu = menuBuilder.getResult();
        System.out.println(menu);
    }
}
