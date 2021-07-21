package DesignPatterns.builder;

public class SaladsMenuBuilder extends MenuBuilder {
    Menu menu = new Menu();

    @Override
    public void buildBurgerOrSalads() {
        menu.add("Burger");


    }

    @Override
    public void buildDesserts() {
        menu.add("Dessert");

    }

    @Override
    public void buildDrink() {
        menu.add("Drink");

    }

    @Override
    public void buildToy() {
        menu.add("Toy");

    }

    @Override
    public void buildFries() {
        menu.add("Fries");

    }

    @Override
    public Menu getResults() {
        return menu;
    }
}
