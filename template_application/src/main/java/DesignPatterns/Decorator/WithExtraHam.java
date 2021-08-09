package DesignPatterns.Decorator;

import java.util.Collections;

public class WithExtraHam extends PizzaToping {


    public WithExtraHam(PizzaElement component) {
        super(component);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 6;
    }

}
