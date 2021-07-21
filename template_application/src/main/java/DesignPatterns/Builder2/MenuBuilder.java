package DesignPatterns.Builder2;

public interface MenuBuilder {

    public void buildBurgerAndSalad();

    public void buildDessert();

    public void buildFries();

    public void buildToy();

    public Menu getResults();
}
