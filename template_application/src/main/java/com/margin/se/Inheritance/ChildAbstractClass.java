package com.margin.se.Inheritance;

public class ChildAbstractClass extends MyAbstractClass {


    @Override
    public void stepBefore() {
        System.out.println("This is the  first step specific to Child");
    }

    @Override
    public void action() {
        System.out.println("This is the action required when processing");

    }

    @Override
    public void stepAfter() {
        System.out.println("This is the last step required for the process");
    }
}
