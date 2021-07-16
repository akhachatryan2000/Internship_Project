package InheritanceExercise4;

public class Main {
    public static void main(String[] args) {
        Dog dog= new Dog("ricky");
        System.out.println(dog);
        dog.greets();
        dog.greets(dog);

    }
}
