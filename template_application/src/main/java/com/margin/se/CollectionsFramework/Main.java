package com.margin.se.CollectionsFramework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Jack");
        arrayList.add("Tyler");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println();
        }

        LinkedList<String> al = new LinkedList<>();
        al.add("Rachit");
        al.add("Rahul");
        al.add("Rajat");
        Iterator iterator1 = al.iterator();
        while (iterator1.hasNext()) {
            System.out.println("LinkedList " + iterator1.next());

        }
        Vector<String> vector = new Vector<>();
        vector.add("Asya");
        vector.add("Marta");
        vector.add("Ishkhan");
        System.out.println(vector.elementAt(0));

        Vector vector1 = new Vector(5, 6);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("dhla");
        queue.add("slkjdlaskj");
        queue.add("dkjlkdc");
        System.out.println("head " + queue.element());
        System.out.println("head " + queue.peek());
        System.out.println("iterating over the queue elements");
        Iterator iterator2 = queue.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println(queue.remove() + " removed"); //removes the head of the queue
        System.out.println(queue.poll() + " removed");  //
        System.out.println("After removing two elements");
        Iterator<String> iterator3 = queue.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        Iterator iterator4 = list.iterator();
        while (iterator4.hasNext()) {
            String value = (String) iterator4.next();
            if (value.equals("456")) {
                list.remove(value);
                System.out.println("removed");
            }
        }
    }

}

