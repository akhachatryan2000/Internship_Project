package com.margin.se.Inheritance;

public abstract class ProcessorBase {
    public void process() {
        System.out.println("Processing");
        processData();
    }

    public abstract void processData();

}
