package com.margin.se.OtherClasses;

public class WirelessVacuumCleaner extends VacuumCleaner {

    @Override
    public void clean() {
        System.out.println("This cleans with battery");

    }

    @Override
    public void speedUp(double speed) {
        super.speedUp(2 * speed);
    }
}
