package DesignPatterns.Builder898;

public class BurgerMenuBuilder implements MenuBuilder{

    Menu menu= new Menu();

    @Override
    public void buildBurgerAndSalads() {
        menu.add("Burger");

    }

    @Override
    public void buildDesserts() {
        menu.add("desserts");

    }

    @Override
    public void buildFries() {
        menu.add("fries");

    }

    @Override
    public void buildToys() {
        menu.add("no toys");

    }

    @Override
    public Menu getResult() {
        return menu;
    }
}
