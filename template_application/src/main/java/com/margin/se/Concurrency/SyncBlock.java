package com.margin.se.Concurrency;

public class SyncBlock {
    private int count = 0;

    public void add(int value) {
        synchronized (this) {
            this.count += value;
        }

    }
}
