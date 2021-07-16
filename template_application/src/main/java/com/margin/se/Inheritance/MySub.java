package com.margin.se.Inheritance;

public class MySub extends MySuper {

    int c = 5;

    MySub(int c) {
        System.out.println("-c " + c);
    }

    void myMethod() {
        System.out.println("-b " + b);
    }

    void fieldCheck() {
        System.out.println("Super's b is " + super.b);
        System.out.println("Child's b is " + this.b);
    }
}
