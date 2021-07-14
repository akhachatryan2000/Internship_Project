package com.margin.se.arrays;

public class Main {
    public static void main(String[] args) {
        ArrayLessons arrayLessons = new ArrayLessons();
        arrayLessons.checkArray();
        arrayLessons.findLength();
        arrayLessons.iterating();
        arrayLessons.printArray();
        arrayLessons.equalityCheck();
        arrayLessons.search();
        arrayLessons.copyArray();


        int[] arrayOfInts = {12, 56, 45};
        int[] arrayOfShorts = {4, 5, 6};
        float[] arrayOfFloats = {0.1f, 0.2f, 0.6f};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("******************");
        System.out.println(arrayOfInts);
        System.out.println("******************");
        System.out.println(arrayOfShorts);
        System.out.println("******************");
        System.out.println(arrayOfFloats);
        System.out.println("******************");
        System.out.println(matrix);


    }
}
