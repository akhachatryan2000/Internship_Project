package passbyvalue;

public class Main {
    public static void main(String[] args) {

        Balloon red= new Balloon("red");
        Balloon blue= new Balloon("blue");

        swap(red, blue);
        System.out.println("red is" + red.hashCode() + red.getColor());
        System.out.println("blue is " + blue.hashCode()+ blue.getColor());

        foo(blue);
        System.out.println("blue is" +blue.hashCode()+blue.getColor());
        foo(red);
        System.out.println("red is" +red.hashCode()+red.getColor());

    }

    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;

    }

    public static void foo(Balloon balloon) {
        balloon.setColor("Red");
        System.out.println("The balloon is" + balloon.hashCode() + balloon.getColor());
        balloon = new Balloon("Green");
        System.out.println("The balloon is" +balloon.hashCode() + balloon.getColor());
        balloon.setColor("Blue");
        System.out.println("The balloon is " + balloon.hashCode() + balloon.getColor());

    }
}
