package com.margin.se;

import com.margin.se.methods.LessonMethods;

public class Main {
    public static void main(String[] args) {
        System.out.println("****************** EXECUTING ASYA MAIN METHOD ************************************");

        LessonMethods lessonMethods = new LessonMethods();
        lessonMethods.firstMethod("text");

        String s1 = "Asya";

        lessonMethods.changeParameters(s1, "hi");
        System.out.println(s1);
        lessonMethods.checkFinal("Asya", "Valod", lessonMethods);
    }
}
