package references;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {

        String name= "John";
        int id=23;
        Person person= null;
        person=PersonBuilder.buildPerson(name,id);

        Demo demo = new Demo();
        System.out.println("The address of demo is " + demo);

        String s1 = "Java";
        String s2 = "Java";
        String s3 = "java";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s2);

        WeakReference <StringBuilder> reference= new WeakReference<>(new StringBuilder()); //weak reference

        WeakHashMap<Integer,String> weakHashMap= new WeakHashMap<>();

        SoftReference <StringBuilder> softReference= new SoftReference<>(new StringBuilder()); //SOFTREFERENCE



    }


}
