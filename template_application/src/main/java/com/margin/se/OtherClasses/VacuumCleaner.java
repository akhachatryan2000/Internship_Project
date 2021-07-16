package com.margin.se.OtherClasses;

public abstract class VacuumCleaner implements Cleaner{

    private int engineSize;

    private String color;

    private String model;

    private double speed;

    public VacuumCleaner() {

    }

    public VacuumCleaner(int engineSize, String color, String model) {
        this.engineSize = engineSize;
        this.color = color;
        this.model = model;
    }


    public abstract void clean();

    public void speedUp(double speed) {
        this.speed += speed;
    }

    public void turnOn() {
        System.out.println("Press the on button");
    }

    public void turnOff() {
        System.out.println("Press the off button");
    }
}
