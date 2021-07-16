package thisandsuper;

public class BMW extends Car {
    int maxSpeed = 89;

    public BMW() {

    }


    public BMW(int m) {
        this.maxSpeed = m;
    }


    public void show() {
        System.out.println(maxSpeed);
        System.out.println(super.maxSpeed);
        System.out.println(this.color);
        System.out.println(super.color);
        System.out.println(this.color == super.color);
        System.out.println(first);
        System.out.println(super.first);
        System.out.println(this.first == super.first);
    }

    public void drive() {
        System.out.println("BMW is faster");
    }

}
