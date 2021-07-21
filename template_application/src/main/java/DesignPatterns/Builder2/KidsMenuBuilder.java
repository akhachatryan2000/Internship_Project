package DesignPatterns.Builder2;

public class KidsMenuBuilder implements MenuBuilder {

    Menu menu = new Menu();


    @Override
    public void buildBurgerAndSalad() {
        menu.add("Kids Burger");

    }

    @Override
    public void buildDessert() {
        menu.add("Juice");

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
