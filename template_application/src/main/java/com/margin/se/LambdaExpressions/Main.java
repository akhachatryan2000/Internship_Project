package com.margin.se.LambdaExpressions;

import DesignPatterns.Composite.P;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> {
            return Integer.getInteger("a",45);
        };
        int res = supplier.get();
        System.out.println(res);
        BinaryOperator<Integer> binaryOperator = (a, b) -> {
            return a + b;
        };
        int result2 = binaryOperator.apply(5, 6);
        System.out.println(result2);

        UnaryOperator<Integer> unaryOperator = (integer -> integer.intValue());
        int result1 = unaryOperator.apply(5);
        System.out.println(result1);


        BiFunction<String, String, String> biFunction = (str1, str2) -> {
            return str1.concat(str2);
        };
        String result = biFunction.appy("Asya", "Khachatryan");
        System.out.println(result);
        Function<String, char[]> function = (str) -> {
            char[] array = str.toCharArray();
            return array;
        };
        char[] array1 = function.apply("hello");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");

        }

    }


}

//        Function<String, char[]> function = (string, chars) -> {
//            char[] c = string.toCharArray();
//
//            BiPredicate<Integer, Integer> biPredicate = (a, g) -> (a > g);
//            boolean b1 = biPredicate.test(5, 6);
//            System.out.println(b1);
//
//            Predicate<Integer> integerPredicate = (a) -> (a % 5 == 0);
//            System.out.println(integerPredicate.test(45));
//            BiConsumer<String, String> biConsumer = (s1, s2) -> {
//                System.out.println(s1);
//                System.out.println(s2);
//            };
//            biConsumer.accpet("Asya", "Khachatryan");
//            Consumer<String> stringConsumer = (name) -> {
//                System.out.println(name);
//            };
//            stringConsumer.accept("Asya");
//
//            Area<Integer, Integer, Integer> area = (a, b) -> (a * b);
//            int result = area.calculateArea(10, 505);
//            System.out.println(result);
//            List<Product> products = new ArrayList<>();
//            products.add(new
//
//                    Product(1, "HP Laptop", 2500f));
//            products.add(new
//
//                    Product(3, "Keyboard", 300f));
//            products.add(new
//
//                    Product(2, "Dell Mouse", 150f));
//            System.out.println("Sorting on the basis of main");
//
//            Collections.sort(products, (p1, p2) ->
//
//            {
//                return p1.name.compareTo(p2.name);
//            });
//            for (
//                    Product p : products) {
//                System.out.println(p.id + " " + p.price + " " + " " + p.name);
//
//            }
//
//            ThreadCreation threadCreation = () -> {
//                System.out.println("THread 1 is running");
//            };
//            Thread thread = new Thread(threadCreation);
//            thread.start();
//            Runnable runnable = () -> {
//                System.out.println("SEcond thread is running");
//            };
//            Thread thread1 = new Thread(runnable);
//            thread1.start();
//
//
//            Multi multi = massage -> {
//                String s1 = "I would like to say";
//                String s2 = massage;
//                return s1 + s2;
//            };
//            System.out.println(multi.say(" time is precious"));
//
//            List<String> list = new ArrayList<>();
//            list.add("jhdkjd");
//            list.add("Asya");
//            list.add("Hello");
//            list.add("HI");
//            list.forEach((n) -> System.out.println(n));
//            Functional functional = () -> {
//                System.out.println("iterating");
//            };
//            functional.iterate();
//
//            Sayable sayable = (String name) -> {
//                return "Hello " + name;
//            };
//            sayable.say("Asya");
//            System.out.println(sayable.say("Asya"));
//
//            Sum sum = (int a, int b) -> {
//                return (a + b);
//            };
//            int sum1 = sum.getSum(10, 20);
//            System.out.println(sum1);
//        }
//
//    }



