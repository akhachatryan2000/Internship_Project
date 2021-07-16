package com.margin.se.Inheritance;

public class DatabasePro extends Employee{

    String databaseTool;

    @Override
    public void print() {
        super.print();
        System.out.println("The database tool is " + databaseTool);
    }
}
