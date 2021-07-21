package com.margin.se.inheritance;

public class

Circle {

    private Rec rec = new Rec();

    public Circle() {
    }

    public Circle(Rec valod) {
        System.out.println(this.rec);

        this.rec = valod;
        System.out.println();
    }

    public Rec getRec() {
        return rec;
    }
}
