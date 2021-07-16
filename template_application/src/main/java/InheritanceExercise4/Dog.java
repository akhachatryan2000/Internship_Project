package InheritanceExercise4;

public class Dog extends Mammal{


    public Dog(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("Woof");
    }
    public void greets(Dog dog) {
        dog.greets();
    }

    @Override
    public String toString() {
        return "Dog{Mammal{Animal{name=}}"+super.toString();
    }
}
