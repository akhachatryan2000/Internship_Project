package DesignPatterns.builder;

public class BurgerMenuBuilder extends MenuBuilder {

    private Menu menu = new Menu();


    @Override
    public void buildBurgerOrSalads() {
        menu.add("Burger");

    }

    @Override
    public void buildDesserts() {
        menu.add("dessert");

    }

    @Override
    public void buildDrink() {
        menu.add("drink");

    }

    @Override
    public void buildToy() {
        menu.add("toy");

    }

    @Override
    public void buildFries() {
        menu.add("fries");
    }

    @Override
    public Menu getResults() {
        return menu;
    }
}
