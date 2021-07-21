package DesignPatterns.Builder2;

public class BurgerMenuBuilder implements MenuBuilder {

    Menu menu = new Menu();

    @Override
    public void buildBurgerAndSalad() {
        menu.add("Burger");

    }

    @Override
    public void buildDessert() {
        menu.add("Dessert");

    }

    @Override
    public void buildFries() {
        menu.add("Fries");

    }

    @Override
    public void buildToy() {
        menu.add("Toy");

    }

    @Override
    public Menu getResults() {
        return menu;
    }
}
