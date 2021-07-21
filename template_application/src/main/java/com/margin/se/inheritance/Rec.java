package com.margin.se.inheritance;

public class Rec {
    private int area;
    private Shape shape;

    public Rec() {
    }

    public Rec(int area, Shape shape) {
        this.area = area;
        this.shape = shape;
    }

    public int getArea() {
        return area;
    }

    public Shape getShape() {
        return shape;
    }
}
