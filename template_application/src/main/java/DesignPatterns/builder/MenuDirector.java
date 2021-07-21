package DesignPatterns.builder;

public class MenuDirector {
    public void construct(MenuBuilder builder) {
        builder.buildBurgerOrSalads();
        builder.buildDesserts();
        builder.buildDrink();
        builder.buildToy();
        builder.buildFries();
    }

}
