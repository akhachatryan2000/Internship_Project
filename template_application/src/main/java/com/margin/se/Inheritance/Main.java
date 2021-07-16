package com.margin.se.Inheritance;


import com.margin.se.Constructors.Vehicle;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

public class Main {
    public static void main(String[] args) {
        MySub mySub= new MySub(4);
        mySub.myMethod();
        mySub.fieldCheck();


        Employee e= new Employee();
        e.name="Emily";
        e.salary=45.6;
        e.age=45;

        Programmer p= new Programmer();
        p.name="Valod";
        p.age=48;
        p.salary=45.89;
        p.language="Java";

        DatabasePro d= new DatabasePro();
        d.name="Karen";
        d.age=89;
        d.salary=45.56;
        d.databaseTool="MongoDB";

        e.print();
        p.print();
        d.print();




       /* Car car = new Car();
        TransportMeans transportMeans = car;
        TransportMeans transportMeans2 = new TransportMeans();


        //upcasting and downcasting check
        //subclass to superclass--upcasting
        //superclass to subclass--downcasting

        TransportMeans transportMeans1 = (TransportMeans) car; //upcasting
        //  Car car1 = (Car) transportMeans2; //downcasting

        car.setProdDate("1998 February");
        transportMeans2.setProdDate("1998 January");
        car.upDateLicense("2000 January");

        boolean isInstance = car instanceof Car;
        System.out.println(isInstance);
        boolean isInsance1 = car instanceof TransportMeans;
        System.out.println(isInsance1);
        System.out.println("A car is also a vehicle");
        boolean isInstance2 = transportMeans instanceof Car;
        System.out.println(isInstance2);

        TransportMeans tm = new TransportMeans();
        boolean b1 = tm instanceof Car;
        System.out.println(b1);
        tm = new Car();
        System.out.println(tm instanceof Car);
        Car c = new Car();
        System.out.println(c instanceof TransportMeans);
        TransportMeans t = new Truck();
        System.out.println(t instanceof Car);

        Car c1 = new Car();
        c1.setLicensePlate("abc");
        System.out.println(c1.getLicensePlate());
        c1.update("123");
        System.out.println(c1.licensePlate);
        transportMeans.setLicensePlate("abc");
        System.out.println(transportMeans.licensePlate);

        Car s= new Car();
        Car.SmallCar smallCar=s.new SmallCar(); // instantiating nested class

        ProcessImpl  processImpl= new ProcessImpl();
        processImpl.process();  // this is an example of Template Method Design Pattern*/

    }
}
