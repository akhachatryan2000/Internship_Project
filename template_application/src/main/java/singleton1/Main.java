package singleton1;

public class Main {
    public static void main(String[] args) {
        //SIngleton single thread
        Singleton singleton = Singleton.getInstance("Foo");
        Singleton singleton1 = Singleton.getInstance("Bar");
        System.out.println(singleton.value);
        System.out.println(singleton1.value);


        //Singleton multi thread
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();


    }
}
