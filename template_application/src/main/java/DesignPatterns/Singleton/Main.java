package DesignPatterns.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    Singleton singleton=Singleton.Instance;


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz= Class.forName("DesignPatterns.Singleton.App");

        Constructor<App> constructor= clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        App app= constructor.newInstance();
    }
}
