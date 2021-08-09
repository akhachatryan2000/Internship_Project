package com.margin.se.Concurrency;

public class Frame {
    private int x = 0;

    public static synchronized void sayHello() {
        System.out.println("Hello");
    }

    public static synchronized void sayGoodBye() {
        System.out.println("Goodbye");
    }


    public synchronized void add(int value) {
        x += value;
    }

    public synchronized void subtract(int valeu) {
        x -= valeu;
    }

    public void add2(int value) {
        synchronized (this) {
            this.x += value;
        }
    }
}
