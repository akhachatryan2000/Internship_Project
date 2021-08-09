package DesignPatterns.Builder898;

public class KidsMenuBuilder implements MenuBuilder {
    Menu menu = new Menu();

    @Override
    public void buildBurgerAndSalads() {

    }

    @Override
    public void buildDesserts() {
        menu.add("Burger for kids");

    }

    @Override
    public void buildFries() {
        menu.add("friies");

    }

    @Override
    public void buildToys() {
        menu.add("toys");
    }

    @Override
    public Menu getResult() {
        return menu;
    }
}
