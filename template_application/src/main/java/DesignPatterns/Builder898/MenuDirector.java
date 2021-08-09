package DesignPatterns.Builder898;

public class MenuDirector {

    public void construct(MenuBuilder builder) {
        builder.buildBurgerAndSalads();
        builder.buildFries();
        builder.buildToys();
        builder.buildDesserts();
    }
}
