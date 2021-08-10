package com.margin.se.inheritance;

public class InheritanceMain {

    public static void main(String[] args) {
        //case 1
        Circle circle = new Circle();
        System.out.println();

        //case 2
        Rec rec = new Rec();
        Circle circle1 = new Circle(rec);
        System.out.println();

        //case 3 nnn n
        Circle circle2 = new Circle(new Rec(0, new Shape()));
        System.out.println();

        //Case 4
        Pol pol = new Pol();
        Circle circle3 = new Circle(new Rec(0, pol));
        System.out.println();

        //Draw images of memories for all three cases. Draw it nice, I want a cartoon image for kids.
    }
}
