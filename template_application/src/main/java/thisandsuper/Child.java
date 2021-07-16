package thisandsuper;

public class Child extends Parent{

    public Child() {

    }


    public Child(String name, int age) {
        super();
       this.name = name;
        this.age=age;
    }


    public void beChild() {
        System.out.println("Comparing child and parent names: " + (this.name == super.name));
        System.out.println("Comparing child and parent memory addresses: " + (this.name.hashCode() == super.name.hashCode()));
        System.out.println("I am the child");
        System.out.println("My name is " + this.name);
        System.out.println("My parent is " + super.name);

    }

    public void seeFields() {
        System.out.println(name);
    }
}
