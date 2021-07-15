package com.margin.se.Inheritance;

import java.util.Locale;

public class Car extends TransportMeans {

    String owner;

    String prodDate;


    @Override
    public void drive() {
        System.out.println("The car is moving");
    }

    @Override
    public void setProdDate(String prodDate) {
        this.prodDate=prodDate.toLowerCase();
        System.out.println(this.prodDate);
        super.setProdDate(prodDate);

    }

    @Override
    public void setLicensePlate(String license) {
        super.setLicensePlate(license);
    }

    @Override
    public String getLicensePlate() {
        return super.getLicensePlate();
    }


    public void upDateLicense(String prodDate) {
        super.setProdDate("2000 January");
    }
    public void update(String license) {
        this.licensePlate=license;
    }

    class SmallCar{

    }
}
