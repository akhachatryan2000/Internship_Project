package com.margin.se.Inheritance;

public abstract class MyAbstractClass {

    public void process() {

    }

    public void stepBefore() {
        System.out.println("This is the action before the process");
    }

    public  void action() {
        System.out.println("This is the action");
    };

    public void stepAfter() {
        System.out.println("This is the action after the process");
    }

}
