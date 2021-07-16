package com.margin.se.methods;

public class LessonMethods {

    String lessonMethod;

    int count;

    public void firstMethod(String n) {
        System.out.println(n);       //methods are operations with data and they must be grouped in classes
    }

    public void checkParameter(String s, LessonMethods lessonMethods) { //using built-in and self-created data types as parameters
        lessonMethods = new LessonMethods();
        s = "hello";

    }

    public void changeParameters(String s1, String s2) {
        System.out.println(s1);
        System.out.println(s2);

        s1 = "newtext";
        s2 = "newtext2";

        System.out.println(s1);
        System.out.println(s2);
    }

    public void checkFinal(final String name, final String name1, LessonMethods l) {
        System.out.println(name);
        System.out.println(name1); //final parameters can't be changed within a method

    }

    public void checkLocalVariables() {
        int local = 5;
        int local1 = 6;
        System.out.println(local);
        System.out.println(local1);
        System.out.println("Now let's declare final variables");

        final LessonMethods lessonMethods = new LessonMethods(); //ref is never changed
        final String s = "hello";
    }

    public int getSum(int s, int s1) {
        return s + s1;
    }


    public String getName(String s, String s1) {
        return s + s1; //returns the concatenation
    }

    public String concat(String first, String second, boolean reverseOrder) {
        if (reverseOrder) {
            return second + first; // if this block is executed the second return is never reached
        }
        return first + second;


    }

    public void callMethod(){
        int sum= getSum(7,5);
        System.out.println(sum);
    }
}
