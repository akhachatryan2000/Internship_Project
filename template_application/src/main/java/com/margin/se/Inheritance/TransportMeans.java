package com.margin.se.Inheritance;

public class TransportMeans {

    String prodDate;

    String owner;

    protected String color;

    public String model;


    public void drive() {
        System.out.println("The machine is moving");
    }

    private String getOwner() {
        return owner;
    }
}
