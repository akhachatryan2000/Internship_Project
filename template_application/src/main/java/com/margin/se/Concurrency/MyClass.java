package com.margin.se.Concurrency;

public class MyClass implements Runnable {
    private int count = 0;
    private MyObject myObject = null;

    public MyClass() {

    }
    public synchronized void log1(String msg1, String msg2){

    }

    public MyClass(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                this.count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
}
