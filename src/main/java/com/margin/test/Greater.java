package com.margin.test;

public class Greater {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        runnable.run();
        Thread thread = new Thread(() -> System.out.println("run"));
        thread.start();
        Thread thread1 = new Thread(new Runnable() { //anonymous inner class
            @Override
            public void run() {
                System.out.println("This is the run method");
            }
        });
        thread1.start();
    }
//        Greater greater = new Greater();
//        greater.greet();
//        greater.greet();
//        StringLength stringLength = (s) -> {
//            return s.length();
//        };
//        stringLength.length("fellow");
//        getLength((s) -> s.length()); //type inference
//
//        greater.greet(() -> {
//            System.out.println("hello world");
//        });
//        Greeting greetingFunction = () -> {
//            System.out.println("hello world");
//        };
//        Greeting greeting = new Greeting() {
//            @Override
//            public void perform() {
//                System.out.println("Hello world");
//            }
//        };
//        StringLength stringLength1 = (s) ->
//                s.length();
//        ;
//        System.out.println(stringLength.length("hello"));
//    }
//
//    public void greet() {
//        System.out.println("Hello world");
//    }
//
//    public void greet(Greeting greeting) {
//        greeting.perform();
//    }
//
//    interface StringLength {
//        int length(String s);
//    }
//
//    public static void getLength(StringLength l) {
//        l.length("hello world");
//    }
}
