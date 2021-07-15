package com.margin.se.Inheritance;

public class TransportMeans {

    String licensePlate;

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

    public void setProdDate(String prodDate) {
        this.prodDate=prodDate;
        System.out.println(this.prodDate);

    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate=licensePlate;
        System.out.println("Now licensePlate is " + licensePlate);
        System.out.println(this.licensePlate);
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }
}
