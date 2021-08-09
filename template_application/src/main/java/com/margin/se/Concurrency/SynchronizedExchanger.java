package com.margin.se.Concurrency;

public class SynchronizedExchanger {
    protected Object object = null;

    public synchronized Object getObject() {
        return object;
    }

    public synchronized void setObject(Object object) {
        this.object = object;
    }

    public void setObj(Object o) {
        synchronized (this) {
            this.object = o;
        }

    }
    public Object getObj(){
        synchronized (this) {
            return object;
        }
    }
}
