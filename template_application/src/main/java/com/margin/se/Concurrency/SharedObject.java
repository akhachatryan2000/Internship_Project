package com.margin.se.Concurrency;



public class SharedObject {
    private int years;

    private int months;


    private volatile int days;


    public void update(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

}
