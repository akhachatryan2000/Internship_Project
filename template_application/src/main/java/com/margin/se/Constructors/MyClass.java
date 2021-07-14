package com.margin.se.Constructors;

public class MyClass {

    String myName;

    String mySurname;


    public MyClass() {

    }

    public MyClass(String myName, String mySurname) {
        //calling a constructor inside a constructor
        this(myName);
        this.mySurname = mySurname;
    }

    public MyClass(String myName) {
        this.myName = myName;
    }
}
