package thisandsuper;

public class Parent {

  String name;

   int age;


    public Parent() {
        System.out.println(name);
        System.out.println(age);
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void beParent() {
        System.out.println("I am the parent");
        System.out.println("My name is " + this.name);
    }

}
