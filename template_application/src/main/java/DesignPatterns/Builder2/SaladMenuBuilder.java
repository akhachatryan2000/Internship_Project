package DesignPatterns.Builder2;

public class SaladMenuBuilder implements MenuBuilder {

    Menu menu = new Menu();

    @Override
    public void buildBurgerAndSalad() {
        menu.add("Salad");

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
