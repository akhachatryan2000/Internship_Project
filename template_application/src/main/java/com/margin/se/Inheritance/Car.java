package com.margin.se.Inheritance;

public class Car extends TransportMeans {

    String owner;

    String prodDate;


    @Override
    public void drive() {
        System.out.println("The car is moving");
    }
}
