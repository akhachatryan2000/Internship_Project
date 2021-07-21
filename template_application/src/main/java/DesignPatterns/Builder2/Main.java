package DesignPatterns.Builder2;

public class Main {
    public static void main(String[] args) {
        MenuDirector director = new MenuDirector();

        MenuBuilder builder = new BurgerMenuBuilder();
        director.construct(builder);
        Menu menu = builder.getResults();
        System.out.println(menu);


        MenuBuilder builder1 = new SaladMenuBuilder();
        director.construct(builder1);
        Menu menu1 = builder1.getResults();
        System.out.println(menu1);

        MenuBuilder builder2 = new KidsMenuBuilder();
        director.construct(builder2);
        Menu menu2 = builder2.getResults();
        System.out.println(menu2);
    }
}
