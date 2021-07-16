package com.margin.se.Inheritance;

public class Programmer extends Employee{

    String language;

    @Override
    public void print() {
        super.print();
        System.out.println("The language is " + language);
    }
}
