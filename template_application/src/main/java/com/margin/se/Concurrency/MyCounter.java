package com.margin.se.Concurrency;

public class MyCounter {
    private static int count = 0;

    public synchronized void add(int value) {
        count += value;

    }

    public synchronized void subtract(int value) {
        count -= value;
    }

    public static synchronized void add1(int value) {
        count += value;
    }

    public synchronized static void subtract1(int value) {
        count -= value;
    }
}
