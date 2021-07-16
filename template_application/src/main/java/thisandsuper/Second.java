package thisandsuper;

public class Second extends First{
    public int x, y;

    public Second() {
        this(0,0);

    }

    public Second(int x, int y) {
        super(x+1, y+1);
        this.x=x;
        this.y=y;
    }

    public void print() {
        System.out.println("The parent class has " + super.x +super.y);
        System.out.println("The child class has " + this.x + this.y);
    }
}
