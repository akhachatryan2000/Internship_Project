package com.margin.se.Concurrency;

public class THREADTEST implements Runnable {
    private int number;

    public void sum() {
        for (int i = 0; i < 1000; i++) {
            number++;
        }
        System.out.println(number+Thread.currentThread().getName());
        System.out.println();

        Thread thraed= new Thread();

    }

    @Override
    public void run() {
        sum();
        System.out.println(number);
    }
}
