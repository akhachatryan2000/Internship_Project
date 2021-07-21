package DesignPatterns.Builder2;

public class MenuDirector {

    public void construct(MenuBuilder builder) {
        builder.buildBurgerAndSalad();
        builder.buildDessert();
        builder.buildFries();
        builder.buildToy();
    }
}
