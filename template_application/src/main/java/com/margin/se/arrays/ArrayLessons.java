package com.margin.se.arrays;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLessons {
    int[] nums = new int[6];
    int[] numbers = new int[]{3, 4, 5};

    public void checkArray() {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = k;
            k++;
            System.out.println(nums[i]);
        }

    }

    public void checkArraySize() {
        int[] array = new int[5];  //the size of an array is not dynamic
        int[] array1 = new int[6];
        int[] array2 = Arrays.copyOf(array, 6);
        ArrayList<Integer> arrayList = new ArrayList<>(); //ArrayList copies the old array and pastes in the new one

    }

    public void findLength() {
        System.out.println(nums.length);
    }

    public void iterating() {
        String[] cities = {"Paris", "Yerevan", "New York", "Los Angeles"};
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
            System.out.println(cities);
        }
    }

    public void printArray() {
        String[] names = {"Asya", "Marta", "Valod", "Davit"};
        System.out.println(Arrays.toString(names));
    }

    public void equalityCheck() {
        String[] cities = {"Paris", "Yerevan", "New York", "Los Angeles"};
        String[] cities1 = {"Paris", "Yerevan", "New York", "Los Angeles"};
        String[] cities2 = {"Paris", "Yerevan", "New York", "Los Angeles", "Gyumri"};
        System.out.println(cities.equals(cities1));
        System.out.println(Arrays.equals(cities, cities2));
        System.out.println(Arrays.equals(cities, cities1));
    }

    public void search() {
        String[] names = {"Paris", "Yerevan", "New York", "Los Angeles"};
        int k = Arrays.binarySearch(names, "Yerevan");
        System.out.println("This is the index of Yerevan" + k);

        int[] numbers = {0, 5, 2, 4};
        int k1 = Arrays.binarySearch(numbers, 1); //this works only on sorted array
        System.out.println(k1);

    }

    public void copyArray() {
        int[] numbers = new int[]{3, 4, 5};
        int[] newArray = Arrays.copyOf(numbers, 5);
        System.out.println(newArray[4]);


    }
}


