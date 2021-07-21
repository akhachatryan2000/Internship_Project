package DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        String[] types = {"tom", "dick", "harry"};
        for (String name : types
        ) {
            Person prototype = Factory.getPrototype(name);
            if (prototype!=null) {
                System.out.println(prototype);
            }
            else {
                System.out.println("The prototype is not cloned");
            }

        }


    }
}
