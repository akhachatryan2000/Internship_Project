package com.margin.se.Concurrency;


import java.net.IDN;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(4, "Asya");
        linkedHashMap.put(4,"LHLJk");
        linkedHashMap.put(6, "lssd");
        linkedHashMap.put(7, "shAHSL");
        Iterator iterator= linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("************************");

        IdentityHashMap<Integer, String> identityHashMap= new IdentityHashMap<>();
        identityHashMap.put(4,"Asya");
        identityHashMap.put(4,"kjhdhskdjh");
        identityHashMap.put(new Integer(4),"jshddSLDK");
        identityHashMap.put(9,"jd");
        Iterator iterator1=identityHashMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
            System.gc();
        }

    }
}











































































































































































































































































































































































