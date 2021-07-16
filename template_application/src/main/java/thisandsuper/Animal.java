package thisandsuper;

public class Animal {

    String type;

    boolean mammal;

    int weight;



    public Animal() {
    }

    public Animal(String type, boolean mammal, int weight) {
        this.type = type;
        this.mammal = mammal;
        this.weight = weight;
    }

    public void checkType() {
        System.out.println("This is an animal");
    }


    public void eat(){
        System.out.println(Animal.class + " is eating");
    }

}
