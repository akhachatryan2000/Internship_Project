package com.margin.se.Constructors;

public class Car extends Vehicle {

    private String model;

    public Car(String regNo, String model) {
        super(regNo);
        this.model = model;
    }
}
