package DesignPatterns.builder;

public abstract class MenuBuilder {

    public abstract void buildBurgerOrSalads();

    public abstract void buildDesserts();

    public abstract void buildDrink();

    public abstract void buildToy();

    public abstract void buildFries();

    public abstract Menu getResults();
}
