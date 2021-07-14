package com.margin.se.AccessModifiersTest;

public class AccessModifiers {

    private String access;

    private int time = 0;

    private AccessModifiers(String access) {
        this.access = access;
    }

    public AccessModifiers(String access, int time) {
        this(access);
        this.time = time;
    }

    private void accseesTest() {
        System.out.println("This method is private");
    }

    public AccessModifiers accessModifiers(String access) {
        return new AccessModifiers(access);
    }
    // accessor methods

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
